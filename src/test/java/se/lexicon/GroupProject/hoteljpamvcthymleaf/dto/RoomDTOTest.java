package se.lexicon.GroupProject.hoteljpamvcthymleaf.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Room;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomDTOTest {

    Room firstRoom;
    Room secondRoom;
    RoomDTO firstRoomDTO;
    RoomDTO secondRoomDTO;
    List<Room> roomList;

    @BeforeEach
    void setUp() {
        firstRoom = new Room("102", "Double", "Your hotel room is smarter than you");
        secondRoom = new Room("100", "Single", "Such a nice room");
        firstRoomDTO = new RoomDTO(firstRoom);
        secondRoomDTO = new RoomDTO(firstRoom);
        roomList = new ArrayList<>();
        roomList.add(firstRoom);
        roomList.add(secondRoom);
    }

    @Test
    void if_convert_room_to_roomDto() {
        assertEquals(firstRoom.getRoomId(), firstRoomDTO.getRoomId());
        assertEquals(firstRoom.getRoomType(), firstRoomDTO.getRoomType());
        assertEquals(firstRoom.getRoomNumber(), firstRoomDTO.getRoomNumber());
        assertEquals(firstRoom.getRoomDescription(), firstRoomDTO.getRoomDescription());
    }

    @Test
    void if_covert_room_list_to_roomDto_list() {
        secondRoom = new Room("100", "Single", "Such a nice room");
        List<Room> roomList = new ArrayList<>();
        roomList.add(firstRoom);
        roomList.add(secondRoom);
        List<RoomDTO> bookDtoList = RoomDTO.toRoomDto(roomList);
        assertEquals(roomList.size(), bookDtoList.size());
    }
}