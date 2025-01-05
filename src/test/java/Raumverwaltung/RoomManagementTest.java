package Raumverwaltung;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomManagementTest {

    private RoomManagement roomManagement;

    @BeforeEach
    void setUp() {
        roomManagement = new RoomManagement();
    }

    @AfterEach
    void tearDown() {
        roomManagement = null;
    }

    @Test
    void addRoom_UpperBoundRoomNumber_AddsCorrectRoom() {
        Room room = new Room(999, 20);
        roomManagement.addRoom(room);
        assertEquals(room, roomManagement.getRoom(999));
    }

    @Test
    void addRoom_LowerBoundRoomNumber_AddsCorrectRoom() {
        Room room = new Room(100, 20);
        roomManagement.addRoom(room);
        assertEquals(room, roomManagement.getRoom(100));
    }

    @Test
    void addRoom_NullRoom_ThrowsException() {
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> roomManagement.addRoom(null)
        );

        assertEquals("Room must not be null.", exception.getMessage());
    }

    @Test
    void addRoom_DuplicateRoomNumber_ThrowsException() {
        Room room1 = new Room(100, 20);
        roomManagement.addRoom(room1);
        Room room2 = new Room(100, 25);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> roomManagement.addRoom(room2)
        );
        assertTrue(exception.getMessage().contains("Room number 100 already exists."));
    }

    @Test
    void getRoom_UpperBoundRoomNumber_ReturnsCorrectRoom(){
        Room room = new Room(999, 20);
        roomManagement.addRoom(room);
        Room retrievedRoom = roomManagement.getRoom(999);
        assertEquals(room, retrievedRoom);
    }

    @Test
    void getRoom_LowerBoundRoomNumber_ReturnsCorrectRoom(){
        Room room = new Room(100, 20);
        roomManagement.addRoom(room);
        Room retrievedRoom = roomManagement.getRoom(100);
        assertEquals(room, retrievedRoom);
    }

    @Test
    void getRoom_MultipleRooms_ReturnsCorrectRoom() {
        Room room1 = new Room(101, 10);
        Room room2 = new Room(102, 20);
        Room room3 = new Room(240, 8);
        roomManagement.addRoom(room1);
        roomManagement.addRoom(room2);
        roomManagement.addRoom(room3);
        assertEquals(room1, roomManagement.getRoom(101));
        assertEquals(room2, roomManagement.getRoom(102));
        assertEquals(room3, roomManagement.getRoom(240));
    }

    @Test
    void getRoom_NonExistingRoom_ThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> roomManagement.getRoom(542)
        );
        assertTrue(exception.getMessage().contains("Room with number 542 does not exist"));
    }
}