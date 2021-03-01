package se.lexicon.GroupProject.hoteljpamvcthymleaf.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Booking;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Hotel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class HotelRepositoryTest {
 Hotel firstHotel;
 Hotel secondHotel;
 Hotel thirdHotel;

    @Autowired
    HotelRepository hotelRepository;

    @BeforeEach
    void setUp() {
        firstHotel = hotelRepository.save(new Hotel("3 star", "My first address", "Description one"));
        secondHotel = hotelRepository.save(new Hotel("4 star", "My second address", "Description two"));
        thirdHotel = hotelRepository.save(new Hotel("5 star", "My third address", "Description three"));

    }

    @Test
    void findAll() {
        assertEquals(3, hotelRepository.findAll().size());
    }

    @Test
    void findAllByHotelAddressContainingIgnoreCase() {
        //Arrange
        String search = "THIRD address";

        //Act
        List<Hotel> foundHotelMatchingSearch = hotelRepository.findAllByHotelAddressContainingIgnoreCase(search);

        //Assert
        assertNotNull(foundHotelMatchingSearch);
        assertFalse(foundHotelMatchingSearch.isEmpty());
        assertEquals(1, foundHotelMatchingSearch.size());
    }

    @Test
    void findAllByHotelDescriptionContainingIgnoreCase() {

        //Arrange
        String search = "TWO";

        //Act
        List<Hotel> foundHotelMatchingSearch = hotelRepository.findAllByHotelDescriptionContainingIgnoreCase(search);

        //Assert
        assertNotNull(foundHotelMatchingSearch);
        assertFalse(foundHotelMatchingSearch.isEmpty());
        assertEquals(1, foundHotelMatchingSearch.size());
    }

    @Test
    void findByHotelId() {
        Hotel hotel = hotelRepository.findByHotelId(firstHotel.getHotelId());
        assertEquals(firstHotel.getHotelId(), hotel.getHotelId());
        assertEquals(firstHotel.getHotelAddress(), hotel.getHotelAddress());
        assertEquals(firstHotel.getHotelType(), hotel.getHotelType());
        assertEquals(firstHotel.getHotelDescription(), hotel.getHotelDescription());
        assertTrue(firstHotel.equals(hotel));
    }
}