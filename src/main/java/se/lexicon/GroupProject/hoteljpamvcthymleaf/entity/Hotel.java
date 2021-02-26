package se.lexicon.GroupProject.hoteljpamvcthymleaf.entity;

import java.util.Objects;

public class Hotel {

    public String hotelId;
    public String hotelType;
    public String hotelAddress;
    public String hotelDescription;

    public Hotel() {
    }

    public Hotel(String hotelType, String hotelAddress, String hotelDescription) {

        this.hotelType = hotelType;
        this.hotelAddress = hotelAddress;
        this.hotelDescription = hotelDescription;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(hotelId, hotel.hotelId) && Objects.equals(hotelType, hotel.hotelType) && Objects.equals(hotelAddress, hotel.hotelAddress) && Objects.equals(hotelDescription, hotel.hotelDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, hotelType, hotelAddress, hotelDescription);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId='" + hotelId + '\'' +
                ", hotelType='" + hotelType + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelDescription='" + hotelDescription + '\'' +
                '}';
    }
}
