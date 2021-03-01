package se.lexicon.GroupProject.hoteljpamvcthymleaf.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Hotel;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Room;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RoomRepositoryTest {

    Room firstRoom;
    Room secondRoom;
    Room thirdRoom;

    @Autowired
    RoomRepository roomRepository;


    @BeforeEach
    void setUp() {
        firstRoom = roomRepository.save(new Room("3d", "First Type", "Good Room"));
        secondRoom =  roomRepository.save(new Room("4a", "Second Type", "Nice Room"));
        thirdRoom = roomRepository.save(new Room("2b", "Third Type", "Best Room"));
    }

    @Test
    void findAll() {
        assertEquals(3, roomRepository.findAll().size());
    }

    @Test
    void findById() {
    }

    @Test
    void findByRoomType() {
    }

    @Test
    void findByRoomId() {
        Room room = roomRepository.findByRoomId(firstRoom.getRoomId());
        assertEquals(firstRoom.getRoomId(), room.getRoomId());
        assertEquals(firstRoom.getRoomDescription(), room.getRoomDescription());
        assertEquals(firstRoom.getRoomType(), room.getRoomType());
        assertEquals(firstRoom.getRoomNumber(), room.getRoomNumber());
        assertTrue(firstRoom.equals(room));
    }
}