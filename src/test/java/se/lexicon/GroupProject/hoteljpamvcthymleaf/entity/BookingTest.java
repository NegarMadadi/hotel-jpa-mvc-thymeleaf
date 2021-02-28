package se.lexicon.GroupProject.hoteljpamvcthymleaf.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    Booking testObject;
    Customer customer;
    Room room;



    @BeforeEach
    void setUp() {
        testObject = new Booking(LocalDate.of(2020,2,2), "singleRoom", "3 nights", customer, room);

        customer = new Customer("Negar", "Madadi", "negar.madadi@gmail.com", LocalDate.of(2021, 1, 1));

    }
    @Test
    void successfully_created() {
        assertNotNull(testObject);
        assertNotEquals("Null", testObject.getBookingId());
        assertEquals("singleRoom", testObject.bookingTitle);
        assertEquals("3 nights" , testObject.bookingDescription);
        assertEquals(LocalDate.of(2020,2,2), testObject.getBookingDate());
    }

    //////
    @Test
    void testEquals() {
        Booking booking = new Booking(LocalDate.of(2020,2,2), "singleRoom", "3 nights", customer, room);
        assertFalse(testObject.equals(booking));
    }

    /////
    @Test
    void testHashCode() {
        Booking booking = new Booking(LocalDate.of(2020,2,2), "singleRoom", "3 nights", customer, room);
        assertNotEquals(booking.hashCode(), testObject.hashCode());
    }

    @Test
    void testToString() {
        String toString = testObject.toString();
        assertTrue(toString.contains("0"));
        assertTrue(toString.contains(testObject.getBookingDescription()));
        assertTrue(toString.contains(testObject.getBookingTitle()));
    }

}