package se.lexicon.GroupProject.hoteljpamvcthymleaf.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    Room testObject;
    @BeforeEach
    void setUp() {
        // testObject = new Room("102", "Double",
        // "Your hotel room is smarter than you", " sea view" , true);
        // testObject = new Room("102", "Double", "Your hotel room is smarter than you");
        testObject = new Room( "102", "Double", "Your hotel room is smarter than you");
    }
    @Test
    void successfully_created() {
        assertNotNull(testObject);
        assertNotEquals("Null", testObject.getRoomId());
        assertEquals("102", testObject.getRoomNumber());
        assertEquals("Double", testObject.getRoomType());
        assertEquals("Your hotel room is smarter than you", testObject.getRoomDescription());
    }
    @Test
    void testEquals() {
        Room room =  new Room( "102", "Double", "Your hotel room is smarter than you");
        assertTrue(testObject.equals(room));
    }
    @Test
    void testHashCode() {
        Room room =  new Room( "102", "Double", "Your hotel room is smarter than you");
        assertEquals(room.hashCode(), testObject.hashCode());
    }
    @Test
    void testToString() {
        String toString = testObject.toString();
        assertTrue(toString.contains("0"));
        assertTrue(toString.contains("102"));
        assertTrue(toString.contains("Double"));
        assertTrue(toString.contains("Your hotel room is smarter than you"));
    }

}