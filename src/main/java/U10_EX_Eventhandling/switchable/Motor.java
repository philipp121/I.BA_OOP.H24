package U10_EX_Eventhandling.switchable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a motor that can be switched on or off and supports event listeners for state changes.
 * Implements the {@link Switchable} interface to provide control over the motor's operational state.
 * Listeners can register to receive notifications about property changes, such as the motor's running state.
 */
public class Motor implements Switchable {
    private static final Logger LOG = LoggerFactory.getLogger(Motor.class);

    private boolean running;
    private int rpm;
    private final List<PropertyChangeListener> listeners;

    /**
     * Initializes a new Motor instance with the motor in the off state.
     * The motor starts with 0 RPM and no registered listeners.
     */
    public Motor() {
        this.listeners = new ArrayList<>();
        this.running = false;
        this.rpm = 0;
    }

    /**
     * Turns the motor on, setting it to a running state with a default RPM of 1000.
     * Fires a property change event to notify all registered listeners about the state change.
     */
    @Override
    public void switchOn() {
        boolean oldState = this.running;
        running = true;
        rpm = 1000;
        LOG.info("Motor switched on. RPM set to: {}", rpm);
        firePropertyChangeEvent("running", oldState, this.running);
    }

    /**
     * Turns the motor off, setting it to a non-running state with 0 RPM.
     * Fires a property change event to notify all registered listeners about the state change.
     */
    @Override
    public void switchOff() {
        boolean oldState = this.running;
        running = false;
        rpm = 0;
        LOG.info("Motor switched off.");
        firePropertyChangeEvent("running", oldState, this.running);
    }

    /**
     * Checks if the motor is currently running.
     *
     * @return {@code true} if the motor is running, {@code false} otherwise.
     */
    @Override
    public boolean isOn() {
        return running;
    }

    /**
     * Checks if the motor is currently not running.
     *
     * @return {@code true} if the motor is not running, {@code false} otherwise.
     */
    @Override
    public boolean isOff() {
        return !isOn();
    }

    /**
     * Retrieves the current RPM (Revolutions Per Minute) of the motor.
     *
     * @return the current RPM value. If the motor is off, this will typically be 0.
     */
    public int getRpm() {
        return rpm;
    }

    /**
     * Registers a property change listener to monitor state changes of the motor.
     * Listeners will be notified when properties such as the motor's running state change.
     *
     * @param listener The listener to be added. Must not be {@code null}.
     * @throws IllegalArgumentException if the listener is {@code null}.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener cannot be null");
        }
        listeners.add(listener);
        LOG.info("Listener added to motor.");

    }

    /**
     * Removes a previously registered property change listener.
     * After removal, the listener will no longer receive property change notifications.
     *
     * @param listener The listener to be removed. Must not be {@code null}.
     * @throws IllegalArgumentException if the listener is {@code null}.
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener cannot be null");
        }
        listeners.remove(listener);
        LOG.info("Listener removed from motor.");
    }

    /**
     * Triggers a property change event for all registered listeners.
     * This method is used internally to notify listeners of changes to motor properties.
     *
     * @param propertyName The name of the property that changed.
     * @param oldValue     The previous value of the property.
     * @param newValue     The updated value of the property.
     */
    private void firePropertyChangeEvent(String propertyName, Object oldValue, Object newValue) {
        LOG.info("Firing property change event: {} [oldValue={}, newValue={}]", propertyName, oldValue, newValue);
        PropertyChangeEvent event = new PropertyChangeEvent(this, propertyName, oldValue, newValue);
        for (PropertyChangeListener listener : listeners) {
            listener.propertyChange(event);
        }
    }
}
