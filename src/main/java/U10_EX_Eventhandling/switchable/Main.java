package U10_EX_Eventhandling.switchable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeListener;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Motor motor = new Motor();

        // Create a simple listener
        PropertyChangeListener listener = evt -> {
            if ("running".equals(evt.getPropertyName())) {
                LOG.info("Listener received motor state change: {}", evt.getNewValue());
            }
        };

        // Test adding the listener
        try {
            LOG.info("Adding listener...");
            motor.addPropertyChangeListener(listener);
        } catch (IllegalArgumentException e) {
            LOG.error("Error adding listener: {}", e.getMessage());
        }

        // Test switching the motor on and off
        LOG.info("Switching motor on...");
        motor.switchOn();

        LOG.info("Switching motor off...");
        motor.switchOff();

        // Test removing the listener
        try {
            LOG.info("Removing listener...");
            motor.removePropertyChangeListener(listener);
        } catch (IllegalArgumentException e) {
            LOG.error("Error removing listener: {}", e.getMessage());
        }
    }
}
