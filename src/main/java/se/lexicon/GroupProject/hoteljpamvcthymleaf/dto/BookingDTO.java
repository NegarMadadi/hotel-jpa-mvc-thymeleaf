package se.lexicon.GroupProject.hoteljpamvcthymleaf.dto;


import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Booking;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingDTO implements Serializable {
    @Null(message = "booking id in necessary")
    private String bookingId;

    @NotNull(message = "customer which booked the room in necessary")
    private CustomerDTO roomTaker;

    @NotNull(message = "booking room is not set")
    private RoomDTO room;

    @NotNull(message = "Required field")
    @PastOrPresent(message = "bookingDate cannot be in the past")
    private LocalDate bookingDate;

    @NotBlank(message = "Required field")
    @Size(min = 2, max = 255, message = "Need to have at least 2 letters")
    private String bookingTitle;

    public CustomerDTO getRoomTaker() {
        return roomTaker;
    }

    public void setRoomTaker(CustomerDTO roomTaker) {
        this.roomTaker = roomTaker;
    }

    public void setRoom(RoomDTO room) {
        this.room = room;
    }

    @NotBlank(message = "Required field")
    @Size(min = 2, max = 255, message = "Need to have at least 2 letters")
    private String bookingDescription;


    public BookingDTO() {
    }

    public BookingDTO(
            //  @Null(message = "booking id in necessary") String bookingId,
            @NotNull(message = "customer which booked the room in necessary") CustomerDTO roomTaker, @NotNull(message = "booking room is not set") RoomDTO room, @NotNull(message = "Required field") @PastOrPresent(message = "bookingDate cannot be in the past") LocalDate bookingDate,
            //@NotBlank(message = "Required field") @Size(min = 2, max = 255, message = "Need to have at least 2 letters") String bookingTitle,
            @NotBlank(message = "Required field") @Size(min = 2, max = 255,
                    message = "Need to have at least 2 letters") String bookingDescription) {
        this.bookingId = bookingId;
        this.roomTaker = roomTaker;
        this.room = room;
        this.bookingDate = bookingDate;
        // this.bookingTitle = bookingTitle;
        this.bookingDescription = bookingDescription;
    }

    public BookingDTO(@NotNull(message = "Required field") @PastOrPresent(message = "bookingDate cannot be in the past") LocalDate bookingDate, @NotBlank(message = "Required field") @Size(min = 2, max = 255, message = "Need to have at least 2 letters") String bookingTitle, @NotBlank(message = "Required field") @Size(min = 2, max = 255, message = "Need to have at least 2 letters") String bookingDescription) {
        this.bookingDate = bookingDate;
        // this.bookingTitle = bookingTitle;
        this.bookingDescription = bookingDescription;
    }

    public BookingDTO(Booking booking) {
        setBookingDate(booking.getBookingDate());
        // setBookingTitle(booking.getBookingTitle());
        setBookingDescription(booking.getBookingDescription());

    }

    public String getBookingId() {
        return bookingId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    /*
    public String getBookingTitle() {
        return bookingTitle;
    }



    public void setBookingTitle(String bookingTitle) {
        this.bookingTitle = bookingTitle;
    }

     */

    public String getBookingDescription() {
        return bookingDescription;
    }

    public void setBookingDescription(String bookingDescription) {
        this.bookingDescription = bookingDescription;
    }


    public RoomDTO getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "bookingId='" + bookingId + '\'' +
                ", bookingDate=" + bookingDate +
                // ", bookingTitle='" + bookingTitle + '\'' +
                ", bookingDescription='" + bookingDescription + '\'' +
                '}';
    }

    public static List<BookingDTO> toBookingDTO(List<Booking> bookings) {
        List<BookingDTO> result = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingDTO bookingDTO = new BookingDTO(booking);
            result.add(bookingDTO);
        }
        return result;
    }

    public static BookingDTO toBookingDto(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO(booking);
        return bookingDTO;
    }
}