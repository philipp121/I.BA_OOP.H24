package Raumverwaltung;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void constructor_shouldInitializeFieldsCorrectly(){
        Room room = new Room(233, 20);
        assertEquals(233, room.getNumber());
        assertEquals(20, room.getCapacity());
        assertEquals(RoomAccessibilityState.FREE, room.getAccessibilityState());
    }

    @Test
    void constructor_shouldInitializeFieldsCorrectlyWithEdgeCasesHigh(){
        Room room = new Room(999, 10);
        assertEquals(999, room.getNumber());
        assertEquals(10, room.getCapacity());
    }

    @Test
    void constructor_shouldInitializeFieldsCorrectlyWithEdgeCasesLow(){
        Room room = new Room(100, 15);
        assertEquals(100, room.getNumber());
        assertEquals(15, room.getCapacity());
    }

    @Test
    void constructor_ThrowsIllegalArgumentExceptionRoomNumber(){
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Room(1000, 5)
        );
        assertEquals("Room number must be between 100 and 999.", exception.getMessage());
    }

    @Test
    void constructor_ThrowsIllegalArgumentExceptionRoomCapacity(){
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Room(341, 1)
        );
        assertEquals("Room capacity must be greater than 2.", exception.getMessage());
    }

    @Test
    void setAccessibilityState_Free(){
        Room room = new Room(110, 20);
        room.setAccessibilityState(RoomAccessibilityState.FREE);
        assertEquals(RoomAccessibilityState.FREE, room.getAccessibilityState());
    }

    @Test
    void setAccessibilityState_Reserved(){
        Room room = new Room(110, 20);
        room.setAccessibilityState(RoomAccessibilityState.RESERVED);
        assertEquals(RoomAccessibilityState.RESERVED, room.getAccessibilityState());
    }

    @Test
    void setAccessibilityState_Blocked(){
        Room room = new Room(110, 20);
        room.setAccessibilityState(RoomAccessibilityState.BLOCKED);
        assertEquals(RoomAccessibilityState.BLOCKED, room.getAccessibilityState());
    }

    @Test
    void setAccessibilityState_NullThrowsIllegalArgumentException(){
        Room room = new Room(110, 20);
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> room.setAccessibilityState(null)
        );
        assertEquals("RoomAccessibilityState must not be null.", exception.getMessage());
    }

    @Test
    void isRoomFree_ReturnsTrueWhenStateIsFree() {
        Room room = new Room(345, 20);
        room.setAccessibilityState(RoomAccessibilityState.FREE);

        assertTrue(room.isRoomFree(), "The room should be free.");
    }

    @Test
    void isRoomFree_ReturnsFalseWhenStateIsNotFree() {
        Room room = new Room(102, 15);
        room.setAccessibilityState(RoomAccessibilityState.RESERVED);

        assertFalse(room.isRoomFree(), "The room should not be free.");
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Room.class)
                .withOnlyTheseFields("roomNumber")
                .verify();
    }
}