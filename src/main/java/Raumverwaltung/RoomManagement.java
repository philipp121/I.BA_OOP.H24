package Raumverwaltung;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


/**
 * The RoomManagement class manages a collection of rooms.
 * It provides methods to add, retrieve, and validate rooms by their room numbers.
 * Rooms are stored in a HashMap, with the room number as the key.
 *
 * @author Philipp Schhüpach
 * @version 1.0.0
 */
@SuppressWarnings({"UnusedReturnValue", "unused"})
public class RoomManagement {

    private static final Logger LOG = LoggerFactory.getLogger(RoomManagement.class);

    /**
     * A map of room numbers to Room objects, where each room number acts as a unique key.
     */
    private final TreeMap<Integer, Room> rooms;
    private final List<RoomEventListener> listeners;
    /**
     * Constructs a new RoomManagement instance with an empty collection of rooms.
     */
    public RoomManagement() {
        this.rooms = new TreeMap<>();
        this.listeners = new ArrayList<>();
    }

    /**
     * Retrieves a Room object by its room number.
     *
     * @param roomNumber The number of the room to retrieve.
     * @return The Room object associated with the given room number.
     * @throws IllegalArgumentException If the room number is invalid or the room does not exist.
     */
     Room getRoom(int roomNumber) {
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
        if (rooms.containsKey(roomNumber)) {
            String message = "Room number " + roomNumber + " already exists.";
            throw new IllegalArgumentException(message);
        }
        this.rooms.put(roomNumber, room);
    }

    /**
     * Registers a property change listener to monitor accessibility state changes of a Room.
     * Listeners will be notified when room accessibility states change.
     *
     * @param listener The listener to be added. Must not be {@code null}.
     * @throws IllegalArgumentException if the listener is {@code null}.
     */
    public void addRoomEventListener(RoomEventListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener cannot be null");
        }
        listeners.add(listener);
        LOG.info("Listener added to Room Management.");
    }

    /**
     * Removes a previously registered property change listener.
     * After removal, the listener will no longer receive property change notifications.
     *
     * @param listener The listener to be removed. Must not be {@code null}.
     * @throws IllegalArgumentException if the listener is {@code null}.
     */
    public void removeRoomEventListener(RoomEventListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener cannot be null");
        }
        listeners.remove(listener);
        LOG.info("Listener removed from Room Management.");
    }

    public boolean reserveRoom(int amountOfPeople){
        Room room = findFreeRoomByCapacity(amountOfPeople);
        if (room == null){
            return false;
        }
        room.setAccessibilityState(RoomAccessibilityState.RESERVED);
        fireRoomEvent(room, amountOfPeople);
        return true;
    }

    /**
     * Finds the smallest free room that can accommodate the specified number of people.
     * <p>
     * The method searches through all available rooms and identifies the smallest room
     * that is free and has a capacity greater than or equal to the required amount.
     * If no such room is found, the method returns {@code null}.
     * </p>
     *
     * @param amountOfPeople The number of people to accommodate.
     * @return The smallest suitable free room, or {@code null} if no room is available.
     */
    private Room findFreeRoomByCapacity(int amountOfPeople) {
        return rooms.values().stream()
                .filter(room -> room.isRoomFree() && room.getCapacity() >= amountOfPeople)
                .min(Comparator.comparingInt(room -> room.getCapacity() - amountOfPeople))
                .orElse(null);
    }

    /**
     * Finds the most suitable free room with sufficient capacity for the given number of people.
     * The method selects the room with the smallest remaining capacity after accommodating the people.
     *
     * @param amountOfPeople The number of people to accommodate.
     * @return The most suitable free room that meets the criteria.
     * @throws NoSuchElementException If no suitable room is available.
     */
    public Room findFreeRoomByCapacity_alternative(int amountOfPeople) {
        Room bestFitRoom = null;
        int smallestRemainingCapacity = Integer.MAX_VALUE;

        for (Room room : rooms.values()) {
            if (room.isRoomFree() && room.getCapacity() >= amountOfPeople) {
                int remainingCapacity = room.getCapacity() - amountOfPeople;
                if (remainingCapacity < smallestRemainingCapacity) {
                    bestFitRoom = room;
                    smallestRemainingCapacity = remainingCapacity;
                }
            }
        }

        if (bestFitRoom == null) {
            throw new NoSuchElementException("No suitable room available.");
        }
        return bestFitRoom;
    }

    /**
     * Releases a reserved room by its room number.
     *
     * @param roomNumber The number of the room to be released.
     * @return {@code true} if the room was successfully released,
     * {@code false} if the room was already free or does not exist.
     */
    public boolean releaseRoom(int roomNumber) {
        try {
            Room room = getRoom(roomNumber);
            if (room.isRoomFree()) {
                return false;
            }
            room.setAccessibilityState(RoomAccessibilityState.FREE);
            fireRoomEvent(room, room.getCapacity());
            return true;
        } catch (IllegalArgumentException e) {
            LOG.error(e.getMessage());
            return false;
        }
    }

    /**
     * Releases a reserved room by its {@link Room} object.
     *
     * @param room The room to be released.
     * @return {@code true} if the room was successfully released,
     * {@code false} if the room was already free or does not exist.
     */
    public boolean releaseRoom(Room room) {
        if (room == null) {
            LOG.error("Attempted to release a null room.");
            return false;
        }
        return releaseRoom(room.getNumber());
    }

    @Override
    public String toString() {
        return "RoomManagement{" +
                "rooms=" + rooms +
                '}';
    }

    /**
     * Provides a multi-line string representation of the Room List.
     *
     * @return a multi-line string representation of the Room List,
     *         or "No Room recorded" if the list is empty.
     */
    public String toFormattedString() {
        return "RoomManagement{\n" +
                "rooms=\n" +
                rooms.values().stream()
                        .map(Room::toString)
                        .reduce((a, b) -> a + ",\n" + b)
                        .orElse("No Room recorded") +
                "\n}";
    }

    /**
     * Fires a room event to all registered listeners.
     * Creates a RoomEvent and invokes the onRoomEvent method of each listener.
     *
     * @param room the Room object associated with the event.
     * @param affectedSeats the type of the event (MINIMUM or MAXIMUM).
     */
    private void fireRoomEvent(Room room, int affectedSeats) {
        RoomEvent event = new RoomEvent(this, room, affectedSeats);
        for (RoomEventListener listener : listeners) {
            listener.onRoomEvent(event);
        }
    }
}

