package se.lexicon.GroupProject.hoteljpamvcthymleaf.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")

    public String hotelId;
    public String hotelType;
    public String hotelAddress;
    public String hotelDescription;
    private boolean available;

    public void setAvailable(boolean availableStatus) {
        this.available = availableStatus;
    }

    @OneToMany(mappedBy = "hotel")
    private List<Room> roomList;


    public Hotel() {
    }

    public Hotel(String hotelType, String hotelAddress, String hotelDescription, List<Room> roomList) {
        this.hotelType = hotelType;
        this.hotelAddress = hotelAddress;
        this.hotelDescription = hotelDescription;
        this.roomList = roomList;
    }

    //this ===> set
    public Hotel(String hotelType, String hotelAddress, String hotelDescription) {
        /*
        this.hotelType = hotelType;
        this.hotelAddress = hotelAddress;
        this.hotelDescription = hotelDescription;

         */
        setHotelType(hotelType);
        setHotelAddress(hotelAddress);
        setHotelDescription(hotelDescription);
    }

    public boolean isAvailable(){
        return available;
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

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(hotelId, hotel.hotelId) && Objects.equals(hotelType, hotel.hotelType) && Objects.equals(hotelAddress, hotel.hotelAddress) && Objects.equals(hotelDescription, hotel.hotelDescription) && Objects.equals(roomList, hotel.roomList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, hotelType, hotelAddress, hotelDescription, roomList);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId='" + hotelId + '\'' +
                ", hotelType='" + hotelType + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelDescription='" + hotelDescription + '\'' +
                ", roomList=" + roomList +
                '}';
    }
}
