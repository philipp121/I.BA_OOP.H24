package U10_EX_Eventhandling.switchable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a light that can be switched on or off.
 * Implements the {@link Switchable} interface for managing its illuminated state.
 */
public class Light implements Switchable {
    private static final Logger LOG = LoggerFactory.getLogger(Light.class);

    private boolean illuminated;

    /**
     * Initializes a new Light instance with the light in the off state.
     * The light starts as not illuminated.
     */
    public Light() {
        this.illuminated = false;
    }

    /**
     * Turns the light on, setting it to an illuminated state.
     * Logs an informational message indicating that the light has been switched on.
     */
    @Override
    public void switchOn() {
        illuminated = true;
        LOG.info("Light switched on.");
    }

    /**
     * Turns the light off, setting it to a non-illuminated state.
     * Logs an informational message indicating that the light has been switched off.
     */
    @Override
    public void switchOff() {
        illuminated = false;
        LOG.info("Light switched off.");
    }

    /**
     * Checks if the light is currently on (illuminated).
     *
     * @return {@code true} if the light is on, {@code false} otherwise.
     */
    @Override
    public boolean isOn() {
        return illuminated;
    }

    /**
     * Checks if the light is currently off (not illuminated).
     *
     * @return {@code true} if the light is off, {@code false} otherwise.
     */
    @Override
    public boolean isOff() {
        return !isOn();
    }
}
