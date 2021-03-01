package se.lexicon.GroupProject.hoteljpamvcthymleaf.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDTOTest {

    Customer firstCustomer;
    Customer secondCustomer;
    List<Customer> customerList;
    CustomerDTO customerDTO;

    @BeforeEach
    void setUp() {

        firstCustomer = new Customer("Negar", "Madadi", "negar.madadi@gmail.com", LocalDate.of(2021, 1, 1));
        secondCustomer = new Customer("Lena", "Sadr", "LenaSadr@gmail.com", LocalDate.of(2021, 03, 1));
        customerDTO = new CustomerDTO(firstCustomer);
       // customerDTO = new CustomerDTO(secondCustomer);
        customerList = new ArrayList<>();
        customerList.add(firstCustomer);
        customerList.add(secondCustomer);
    }

    @Test
    void if_converts_List_of_books_to_List_of_bookDTOs() {
        List<CustomerDTO> libraryUserDTOs = CustomerDTO.toCustomerDto(customerList);
        assertEquals(customerList.size(), libraryUserDTOs.size());
    }

    @Test
    void if_convert_libraryUser_toLibraryUserDto() {
        assertEquals(firstCustomer.getCustomerId(), customerDTO.getCustomerId());
        assertEquals(firstCustomer.getCustomerFirstName(), customerDTO.getFirstName());
        assertEquals(firstCustomer.getCustomerLastName(), customerDTO.getLastName());
        assertEquals(firstCustomer.getCustomerEmail(), customerDTO.getEmail());


       // assertEquals(secondCustomer.getCustomerLastName(), customerDTO.getLastName());
    }
}