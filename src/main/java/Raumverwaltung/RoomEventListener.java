package Raumverwaltung;

import U10_EX_Eventhandling.temperatur.TemperatureEvent;

/**
 * Listener interface for receiving room accessibility state change events.
 * Classes interested in processing room accessibility events should implement this interface.
 */
@FunctionalInterface
public interface RoomEventListener {
    /**
     * Invoked when a temperature change event occurs.
     *
     * @param event the RoomEvent object containing event details.
     */
    void onRoomEvent(RoomEvent event);
}
