package se.lexicon.GroupProject.hoteljpamvcthymleaf.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Booking {

    public String bookingId;
    public LocalDate bookingDate;
    public String bookingTitle;
    public String bookingDescription;

    public Booking() {
    }

    public Booking(LocalDate bookingDate, String bookingTitle, String bookingDescription) {
        setBookingDate(bookingDate);
        setBookingTitle(bookingTitle);
        setBookingDescription(bookingDescription);
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

    public String getBookingTitle() {
        return bookingTitle;
    }

    public void setBookingTitle(String bookingTitle) {
        this.bookingTitle = bookingTitle;
    }

    public String getBookingDescription() {
        return bookingDescription;
    }

    public void setBookingDescription(String bookingDescription) {
        this.bookingDescription = bookingDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId) && Objects.equals(bookingDate, booking.bookingDate) && Objects.equals(bookingTitle, booking.bookingTitle) && Objects.equals(bookingDescription, booking.bookingDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, bookingDate, bookingTitle, bookingDescription);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", bookingDate=" + bookingDate +
                ", bookingTitle='" + bookingTitle + '\'' +
                ", bookingDescription='" + bookingDescription + '\'' +
                '}';
    }
}
