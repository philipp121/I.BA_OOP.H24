package Raumverwaltung;

import java.util.Objects;

/**
 * Represents a Room object.
 *
 * @author Philipp Schhüpach
 * @version 1.0.0
 */
public final class Room {
    private final int roomNumber;
    private final int roomCapacity;
    private RoomAccessibilityState roomAccessibilityState;

    /**
     * Constructs a Room Object.
     * It also checks if the passed roomNumber is between 100 and 999, if the passed roomCapacity is greater than 2
     * and throws an error if it is not the case.
     * Constructor is package-private
     * @param roomNumber the Number of the room from 100 to 999.
     * @param roomCapacity the capacity of the room. Minimum 2.
     * @throws IllegalArgumentException if roomNumber is not between 100 and 999 and roomCapacity is not greater than 2
     */
    Room(int roomNumber, int roomCapacity) {
        validateRoomNumber(roomNumber);
        if (roomCapacity < 2) {
            throw new IllegalArgumentException("Room capacity must be greater than 2.");
        }
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.roomAccessibilityState = RoomAccessibilityState.FREE;
    }

    /**
     * Retrieve the Room number
     *
     * @return The Room number.
     */
    public int getNumber() {
        return roomNumber;
    }

    /**
     * Retrieve the Room capacity
     *
     * @return The Room capacity.
     */
    public int getCapacity() {
        return roomCapacity;
    }

    /**
     * Retrieve the Room Accessibility State
     *
     * @return The Room Accessibility State.
     */
    public RoomAccessibilityState getAccessibilityState() {
        return roomAccessibilityState;
    }

    /**
     * Checks whether the room is currently in a "FREE" state.
     *
     * @return {@code true} if the room's accessibility state is {@link RoomAccessibilityState#FREE},
     *         {@code false} otherwise.
     */
    public boolean isRoomFree(){
        return roomAccessibilityState == RoomAccessibilityState.FREE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        return roomNumber == room.roomNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(roomNumber);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomCapacity=" + roomCapacity +
                ", roomAccessibilityState=" + roomAccessibilityState +
                '}';
    }

    /**
     * Validates if the passed roomNumber is between 100 and 999
     * @param roomNumber the Room Number to validate
     * @throws IllegalArgumentException if roomNumber is not between 100 and 999
     */
    public static void validateRoomNumber(int roomNumber) {
        if (roomNumber < 100 || roomNumber > 999) {
            throw new IllegalArgumentException("Room number must be between 100 and 999.");
        }
    }

    /**
     * Set the Room Accessibility State
     * Method is package-private
     * @param roomAccessibilityState the new Room Accessibility State.
     * @throws IllegalArgumentException  if RoomAccessibilityState is null
     */
    void setAccessibilityState(RoomAccessibilityState roomAccessibilityState) {
        this.roomAccessibilityState = Objects.requireNonNull(
                roomAccessibilityState,
                "RoomAccessibilityState must not be null."
        );
    }
}
