package se.lexicon.GroupProject.hoteljpamvcthymleaf.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Customer;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Room;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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

        bookingDTO = new BookingDTO(LocalDate.of(2021, 02, 12), "Book Title", "Book Description");

    }

    @Test
    void creating_new_bookingDto_object() {}

}