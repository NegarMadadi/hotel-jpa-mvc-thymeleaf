package se.lexicon.GroupProject.hoteljpamvcthymleaf.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Hotel;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Room;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelDTOTest {
    Hotel firstHotel;
    Hotel secondHotel;
    HotelDTO firstHotelDTO;
    HotelDTO secondHotelDTO;
    List<Hotel> hotelList;


    @BeforeEach
    void setUp() {
        firstHotel = new Hotel("5 star", " London 123", "Best Hotel ever seen", true);
        secondHotel = new Hotel("10 star", "Stockholm 789", "Best quality", true);
        firstHotelDTO = new HotelDTO(firstHotel);
        secondHotelDTO = new HotelDTO(secondHotel);
        hotelList = new ArrayList<>();
        hotelList.add(firstHotel);
        hotelList.add(secondHotel);
    }

    @Test
    void if_convert_hotel_to_hotelDto() {
        assertEquals(firstHotel.getHotelId(), firstHotelDTO.getHotelId());
        assertEquals(firstHotel.getHotelType(), firstHotelDTO.getHotelType());
        assertEquals(firstHotel.getHotelAddress(), firstHotelDTO.getHotelAddress());
        assertEquals(firstHotel.getHotelDescription(), firstHotelDTO.getHotelDescription());
    }

    @Test
    void if_covert_hotel_list_to_hotelDto_list() {
        secondHotel = new Hotel("10 star", "Stockholm 789", "Best quality", true);
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(firstHotel);
        hotelList.add(secondHotel);
        List<HotelDTO> hotelDtoList = HotelDTO.toHotelDto(hotelList);
        assertEquals(hotelList.size(), hotelDtoList.size());
    }
}