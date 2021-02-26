package se.lexicon.GroupProject.hoteljpamvcthymleaf.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer testObject;
    @BeforeEach
    void setUp() {
        testObject = new Customer("Negar", "Madadi", "negar.madadi@gmail.com", LocalDate.of(2021,1,1));
    }

    @Test
    void successfully_created(){
        assertNotNull(testObject);
        assertNotEquals("Null", testObject.getCustomerId());
        assertEquals("Negar", testObject.getCustomerFirstName());
        assertEquals("Madadi", testObject.getCustomerLastName());
        assertEquals("negar.madadi@gmail.com", testObject.getCustomerEmail());
        assertEquals( LocalDate.of(2021,1,1), testObject.getBookingDate());

    }
    @Test
    void testEquals() {
        Customer customer = new Customer("Negar", "Madadi", "negar.madadi@gmail.com",  LocalDate.of(2021,1,1));
        assertTrue(testObject.equals(customer));
    }
    @Test
    void testHashcode() {
        Customer copy = new Customer("Negar", "Madadi", "negar.madadi@gmail.com",  LocalDate.of(2021,1,1) );
        assertEquals(copy.hashCode(), testObject.hashCode());
    }
    @Test
    void testToString() {
        String toString = testObject.toString();
        assertTrue(toString.contains("0"));
        assertTrue(toString.contains(testObject.getCustomerFirstName()));
        assertTrue(toString.contains(testObject.getCustomerLastName()));
        assertTrue(toString.contains(testObject.getCustomerEmail()));
    }

}