package U10_EX_Eventhandling.temperatur;

import java.io.Serial;
import java.util.EventObject;

/**
 * Represents an event related to temperature changes.
 * This event is triggered when a new minimum or maximum temperature is detected.
 */
public class TemperatureEvent extends EventObject {
    @Serial
    private static final long serialVersionUID = -3786979037048745345L;

    private final Temperature temperature;
    private final TemperatureEventType type;

    /**
     * Constructs a TemperatureEvent with the specified source, temperature, and type.
     *
     * @param source      the object on which the Event initially occurred.
     * @param temperature the Temperature associated with this event.
     * @param type        the type of the temperature event.
     * @throws IllegalArgumentException if source, temperature, or type is null.
     */
    public TemperatureEvent(Object source, Temperature temperature, TemperatureEventType type) {
        super(source);
        if (temperature == null || type == null) {
            throw new IllegalArgumentException("Temperature and type cannot be null.");
        }
        this.temperature = temperature;
        this.type = type;
    }

    /**
     * Gets the temperature associated with the event.
     *
     * @return The Temperature.
     */
    public Temperature getTemperature() {
        return temperature;
    }

    /**
     * Gets the type of the temperature event.
     *
     * @return The event type (MINIMUM or MAXIMUM).
     */
    public TemperatureEventType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TemperaturEvent{" +
                "source=" + getSource().getClass().getSimpleName() +
                ",temperature=" + temperature +
                ", type=" + type +
                '}';
    }
}
