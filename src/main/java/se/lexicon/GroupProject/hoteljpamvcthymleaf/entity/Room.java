package se.lexicon.GroupProject.hoteljpamvcthymleaf.entity;

import java.util.Objects;

public class Room {

    private String roomId;
    private String roomNumber;
    private String roomType;
    private String roomDescription;

    public Room() {
    }

    public Room(String roomNumber, String roomType, String roomDescription) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomDescription = roomDescription;
    }

    public String getRoomId() {
        return roomId;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomId, room.roomId) && Objects.equals(roomNumber, room.roomNumber) && Objects.equals(roomType, room.roomType) && Objects.equals(roomDescription, room.roomDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, roomNumber, roomType, roomDescription);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomDescription='" + roomDescription + '\'' +
                '}';
    }
}
