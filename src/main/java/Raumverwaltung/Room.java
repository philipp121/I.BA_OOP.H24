package Raumverwaltung;

import java.util.Objects;

public final class Room {
    private final int roomNumber;
    private final int roomCapacity;

    Room(int roomNumber, int roomCapacity) {
        if (roomNumber < 100 || roomNumber > 999) {
            throw new IllegalArgumentException("Room number must be between 100 and 999.");
        }
        if (roomCapacity < 2) {
            throw new IllegalArgumentException("Room capacity must be greater than 2.");
        }
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
    }

    public int getNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return roomCapacity;
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
}
