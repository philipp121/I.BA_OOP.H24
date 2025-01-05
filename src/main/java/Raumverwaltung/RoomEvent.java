package Raumverwaltung;

import java.util.EventObject;

/**
 * Represents an event related to room accessibility changes.
 * This event is triggered when a room is reserved or freed up.
 */
public class RoomEvent extends EventObject {

    private final Room room;
    private final int affectedSeats;

    /**
     * Constructs a RoomEvent with the specified source, room and affected seats.
     *
     * @param source the object on which the Event initially occurred
     * @param room the room associated with this event
     * @param affectedSeats the amount of affected Seats in this event
     * @throws IllegalArgumentException if source is null
     */
    public RoomEvent(Object source, Room room, int affectedSeats) {
        super(source);
        this.room = room;
        this.affectedSeats = affectedSeats;
    }

    /**
     * Retrieves the Room associated with the event.
     *
     * @return The Room of the event.
     */
    public Room getRoom() {
        return room;
    }
    /**
     * Retrieves amount of affected seats associated with the event.
     *
     * @return The amount of affected seats of the event.
     */
    public int getAffectedSeats() {
        return affectedSeats;
    }

    @Override
    public String toString() {
        return "RoomEvent{" +
                "room=" + room +
                ", affectedSeats=" + affectedSeats +
                '}';
    }
}
