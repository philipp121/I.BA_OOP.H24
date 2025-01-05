package U10_EX_Eventhandling.switchable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Represents a car with a motor and two front lights, all of which can be switched on or off.
 * Implements the {@link Switchable} interface to provide control over the car's operational state.
 * The car also includes an anonymous property change listener to monitor motor state changes.
 */
public class Car implements Switchable, PropertyChangeListener {
    private static final Logger LOG = LoggerFactory.getLogger(Switchable.class);

    private final Motor motor;
    private final Light lightFrontLeft;
    private final Light lightFrontRight;

    /**
     * Initializes a new Car instance with a motor and two front lights.
     * Registers an anonymous listener to monitor and log changes in the motor's running state.
     */
    public Car() {
        this.motor = new Motor();
        this.lightFrontLeft = new Light();
        this.lightFrontRight = new Light();
        LOG.info("Car initialized with motor and lights.");
    }

    /**
     * Switches the car on by turning on the motor and both front lights.
     * Logs the action and updates the state of all components.
     */
    @Override
    public void switchOn() {
        LOG.info("Switching car on...");
        motor.switchOn();
        lightFrontLeft.switchOn();
        lightFrontRight.switchOn();
        LOG.info("Car is now on.");
    }

    /**
     * Switches the car off by turning off the motor and both front lights.
     * Logs the action and updates the state of all components.
     */
    @Override
    public void switchOff() {
        LOG.info("Switching car off...");
        motor.switchOff();
        lightFrontLeft.switchOff();
        lightFrontRight.switchOff();
        LOG.info("Car is now off.");
    }

    /**
     * Checks if the car is currently on.
     * The car is considered "on" if the motor and both front lights are on.
     *
     * @return {@code true} if the car is on, {@code false} otherwise.
     */
    @Override
    public boolean isOn() {
        return motor.isOn() && lightFrontLeft.isOn() && lightFrontRight.isOn();
    }

    /**
     * Checks if the car is currently off.
     * The car is considered "off" if either the motor or one of the lights is off.
     *
     * @return {@code true} if the car is off, {@code false} otherwise.
     */
    @Override
    public boolean isOff() {
        return !isOn();
    }

    /**
     * Retrieves the motor of the car.
     *
     * @return the motor instance associated with the car.
     */
    public Motor getMotor() {
        return motor;
    }

    /**
     * Retrieves the front-left light of the car.
     *
     * @return the front-left light instance associated with the car.
     */
    public Light getLightFrontLeft() {
        return lightFrontLeft;
    }

    /**
     * Retrieves the front-right light of the car.
     *
     * @return the front-right light instance associated with the car.
     */
    public Light getLightFrontRight() {
        return lightFrontRight;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("running".equals(evt.getPropertyName())) {
            boolean newState = (boolean) evt.getNewValue();
            LOG.info("Motor state changed: {}", newState ? "ON" : "OFF");
        }
    }
}
