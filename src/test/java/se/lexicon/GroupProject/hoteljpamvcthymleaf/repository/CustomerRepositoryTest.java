package se.lexicon.GroupProject.hoteljpamvcthymleaf.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Booking;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Customer;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {
    Customer testObject;
    Customer firstCustomer;
    Customer secondCustomer;
    Customer thirdCustomer;

    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        firstCustomer = customerRepository.save(new Customer("Elmira", "Madadi", "elmiramadadi@gmail.com", LocalDate.now()));
        secondCustomer = customerRepository.save(new Customer("Negar", "Madadi", "negarmadadi@gmail.com", LocalDate.now()));
        thirdCustomer = customerRepository.save(new Customer("Lena", "Sadr", "lenasadr.gmai.com", LocalDate.now()));
    }

    @Test
    void findAll() {
        assertEquals(3, customerRepository.findAll().size());
    }

    @Test
    void findAllByCustomerFirstNameContainingIgnoreCase() {
        //Arrange
        String search = "NEGAR";

        //Act
        List<Customer> foundCustomerMatchingSearch = customerRepository.findAllByCustomerFirstNameContainingIgnoreCase(search);

        //Assert
        assertNotNull(foundCustomerMatchingSearch);
        assertFalse(foundCustomerMatchingSearch.isEmpty());
        assertEquals(1, foundCustomerMatchingSearch.size());
        assertTrue(foundCustomerMatchingSearch.contains(secondCustomer));
    }

    @Test
    void findAllByCustomerLastNameContainingIgnoreCase() {
        //Arrange
        String search = "SADR";

        //Act
        List<Customer> foundCustomerMatchingSearch = customerRepository.findAllByCustomerLastNameContainingIgnoreCase(search);

        //Assert
        assertNotNull(foundCustomerMatchingSearch);
        assertFalse(foundCustomerMatchingSearch.isEmpty());
        assertEquals(1, foundCustomerMatchingSearch.size());
    }

    @Test
    void findAllByCustomerEmailContainingIgnoreCase() {
        //Arrange
        String search = "SADR";

        //Act
        List<Customer> foundCustomerMatchingSearch = customerRepository.findAllByCustomerLastNameContainingIgnoreCase(search);

        //Assert
        assertNotNull(foundCustomerMatchingSearch);
        assertFalse(foundCustomerMatchingSearch.isEmpty());
        assertEquals(1, foundCustomerMatchingSearch.size());
    }

    @Test
    void findByCustomerId() {
        Customer customer = customerRepository.findByCustomerId(firstCustomer.getCustomerId());
        assertEquals(firstCustomer.getCustomerId(), customer.getCustomerId());
        assertEquals(firstCustomer.getCustomerFirstName(), customer.getCustomerFirstName());
        assertEquals(firstCustomer.getCustomerLastName(), customer.getCustomerLastName());
        assertEquals(firstCustomer.getCustomerEmail(), customer.getCustomerEmail());
        assertEquals(firstCustomer.getBookingDate(), customer.getBookingDate());
        assertTrue(firstCustomer.equals(customer));
    }
}