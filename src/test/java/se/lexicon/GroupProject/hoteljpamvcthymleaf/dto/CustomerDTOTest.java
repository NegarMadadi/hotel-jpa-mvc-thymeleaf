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
    CustomerDTO customerDTO1;
    CustomerDTO customerDTO2;

    @BeforeEach
    void setUp() {

        firstCustomer = new Customer("Negar", "Madadi", "negar.madadi@gmail.com", LocalDate.of(2021, 1, 1));
        secondCustomer = new Customer("Lena", "Sadr", "LenaSadr@gmail.com", LocalDate.of(2021, 03, 1));
        customerDTO1 = new CustomerDTO(firstCustomer);
        customerDTO2 = new CustomerDTO(secondCustomer);
        customerList = new ArrayList<>();
        customerList.add(firstCustomer);
        customerList.add(secondCustomer);
    }

    @Test
    void if_converts_List_of_customer_to_List_of_customerDTOs() {
        List<CustomerDTO> libraryUserDTOs = CustomerDTO.toCustomerDto(customerList);
        assertEquals(customerList.size(), libraryUserDTOs.size());
    }

    @Test
    void if_convert_Customer_toCustomerDto() {
        assertEquals(firstCustomer.getCustomerId(), customerDTO1.getCustomerId());
        assertEquals(firstCustomer.getCustomerFirstName(), customerDTO1.getFirstName());
        assertEquals(firstCustomer.getCustomerLastName(), customerDTO1.getLastName());
        assertEquals(firstCustomer.getCustomerEmail(), customerDTO1.getEmail());
        assertEquals(secondCustomer.getCustomerLastName(), customerDTO2.getLastName());
    }
}