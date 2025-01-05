package U10_EX_Eventhandling.switchable;

/**
 * Represents an interface for objects that can be switched on and off.
 * Provides methods to control and query the on/off state of the object.
 */
public interface Switchable {

    /**
     * Activates or powers on the object.
     * The object transitions to an "on" state.
     */
    void switchOn();

    /**
     * Deactivates or powers off the object.
     * The object transitions to an "off" state.
     */
    void switchOff();

    /**
     * Determines if the object is currently in the "on" state.
     *
     * @return {@code true} if the object is on, {@code false} otherwise.
     */
    boolean isOn();

    /**
     * Determines if the object is currently in the "off" state.
     *
     * @return {@code true} if the object is off, {@code false} otherwise.
     */
    boolean isOff();
}
