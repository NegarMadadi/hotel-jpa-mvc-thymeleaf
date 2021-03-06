package se.lexicon.GroupProject.hoteljpamvcthymleaf.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Customer;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Room;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookingDTOTest {
    RoomDTO firstRoomDTO;
    RoomDTO secondRoomDTO;

    CustomerDTO firstCustomerDTO;
    CustomerDTO secondCustomerDTO;

    BookingDTO bookingDTO;


    @BeforeEach
    void setUp() {
        Room firstRoom = new Room("102", "Double", "Your hotel room is smarter than you");
        Room secondRoom = new Room("100", "Single", "Such a nice room");
        firstRoomDTO = new RoomDTO(firstRoom);
        secondRoomDTO = new RoomDTO(secondRoom);

        Customer firstCustomer = new Customer("Negar", "Madadi", "negar.madadi@gmail.com", LocalDate.of(2021, 1, 1));
        Customer secondCustomer = new Customer("Lena", "Sadr", "LenaSadr@gmail.com", LocalDate.of(2021, 03, 1));
        firstCustomerDTO = new CustomerDTO(firstCustomer);
        secondCustomerDTO = new CustomerDTO(secondCustomer);

        bookingDTO = new BookingDTO(firstCustomerDTO, firstRoomDTO, LocalDate.now(), firstRoomDTO.getRoomDescription());

    }

    @Test
    void creating_new_bookingDto_object() {
        assertEquals(firstRoomDTO.getRoomId(), bookingDTO.getRoom().getRoomId());
        assertEquals(firstRoomDTO.getRoomDescription(), bookingDTO.getRoom().getRoomDescription());
        assertEquals(firstRoomDTO.getRoomNumber(), bookingDTO.getRoom().getRoomNumber());
        assertEquals(firstRoomDTO.getRoomType(), bookingDTO.getRoom().getRoomType());
        assertEquals(firstCustomerDTO.getCustomerId(), bookingDTO.getRoomTaker().getCustomerId());
        assertEquals(firstCustomerDTO.getFirstName(), bookingDTO.getRoomTaker().getFirstName());
        assertEquals(firstCustomerDTO.getLastName(), bookingDTO.getRoomTaker().getLastName());
        assertEquals(firstCustomerDTO.getEmail(), bookingDTO.getRoomTaker().getEmail());
        assertEquals(firstCustomerDTO.getBookingDate(), bookingDTO.getRoomTaker().bookingDate);
    }
}