package se.lexicon.GroupProject.hoteljpamvcthymleaf.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Booking;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookingRepositoryTest {

    Booking testObject;
    Booking firstBooking;
    Booking secondBooking;
    Booking thirdBooking;

    @Autowired
    BookingRepository bookingRepository;

    @BeforeEach
    void setUp() {

      firstBooking = bookingRepository.save(new Booking(LocalDate.of(2012, 5, 3), "My room title 3", "booking description 1"));
      secondBooking = bookingRepository.save(new Booking(LocalDate.of(2013, 6, 22), "My room title 2", "booking description 2"));
      thirdBooking = bookingRepository.save(new Booking(LocalDate.of(2015, 5, 3), "my room title 3", "booking description 3"));
    }

    @Test
    void findAll() {
     assertEquals(3, bookingRepository.findAll().size());
    }

    @Test
    void findByBookingId() {
        Booking booking = bookingRepository.findByBookingId(firstBooking.getBookingId());
        assertEquals(firstBooking.getBookingId(), booking.getBookingId());
        assertEquals(firstBooking.getBookingDescription(), booking.getBookingDescription());
        assertEquals(firstBooking.getBookingTitle(), booking.bookingTitle);
        assertEquals(firstBooking.getBookingDate(), booking.getBookingDate());
        assertTrue(firstBooking.equals(booking));
    }
}