package Raumverwaltung;

import java.util.Objects;
import java.util.TreeMap;


/**
 * The RoomManagement class manages a collection of rooms.
 * It provides methods to add, retrieve, and validate rooms by their room numbers.
 * Rooms are stored in a HashMap, with the room number as the key.
 */
public class RoomManagement {

    /**
     * A map of room numbers to Room objects, where each room number acts as a unique key.
     */
    private final TreeMap<Integer, Room> rooms;

    /**
     * Constructs a new RoomManagement instance with an empty collection of rooms.
     */
    public RoomManagement() {
        this.rooms = new TreeMap<>();
    }

    /**
     * Retrieves a Room object by its room number.
     *
     * @param roomNumber The number of the room to retrieve.
     * @return The Room object associated with the given room number.
     * @throws IllegalArgumentException If the room number is invalid or the room does not exist.
     */
    public Room getRoom(int roomNumber){
        Room.validateRoomNumber(roomNumber);
        Room room = rooms.get(roomNumber);
        if (room == null) {
            String message = "Room with number " + roomNumber + " does not exist.";
            throw new IllegalArgumentException(message);
        }
        return room;
    }

    /**
     * Adds a new Room object to the management system.
     *
     * @param room The Room object to add.
     * @throws IllegalArgumentException If the room is null or if a room with the same number already exists.
     */
    public void addRoom(Room room) {
        Objects.requireNonNull(
                room,
                "Room must not be null."
        );
        int roomNumber = room.getNumber();
        if (rooms.containsKey(roomNumber)){
            String message = "Room number " + roomNumber + " already exists.";
            throw new IllegalArgumentException(message);
        }
        this.rooms.put(roomNumber, room);
    }
}
