package Raumverwaltung;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeListener;

public class Demo {
    private static final Logger LOG = LoggerFactory.getLogger(Demo.class);
    public static void main(String[] args) {
        RoomManagement roomManagement = new RoomManagement();
        roomManagement.addRoom(new Room(600, 18));
        roomManagement.addRoom(new Room(602, 6));
        roomManagement.addRoom(new Room(603, 12));
        roomManagement.addRoom(new Room(605, 24));
        roomManagement.addRoom(new Room(610, 12));

        RoomEventListener listener = evt -> {
            switch (evt.getRoom().getAccessibilityState()) {
                case RoomAccessibilityState.RESERVED -> LOG.info("Room Number {} was reserved with {} reserved seats",
                    evt.getRoom().getNumber(),
                    evt.getAffectedSeats()
                );
                case RoomAccessibilityState.FREE -> LOG.info("Room Number {} was freed with {} freed seats",
                        evt.getRoom().getNumber(),
                        evt.getAffectedSeats()
                );
            }
        };

        try {
            LOG.info("Adding listener...");
            roomManagement.addRoomEventListener(listener);
        } catch (IllegalArgumentException e) {
            LOG.error("Error adding listener: {}", e.getMessage());
        }

        roomManagement.reserveRoom(11);
        roomManagement.reserveRoom(6);
        roomManagement.reserveRoom(17);
        roomManagement.releaseRoom(603);
        roomManagement.releaseRoom(602);
        roomManagement.releaseRoom(610);

        System.out.println(roomManagement.toFormattedString());

        try {
            LOG.info("Removing listener...");
            roomManagement.removeRoomEventListener(listener);
        } catch (IllegalArgumentException e) {
            LOG.error("Error removing listener: {}", e.getMessage());
        }
    }
}
