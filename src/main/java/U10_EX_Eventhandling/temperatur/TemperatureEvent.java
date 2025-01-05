package U10_EX_Eventhandling.temperatur;

import java.io.Serial;
import java.util.EventObject;

/**
 * Represents a temperature event, including its type (minimum or maximum).
 */
public class TemperatureEvent extends EventObject {
    @Serial
    private static final long serialVersionUID = -3786979037048745345L;

    private final Temperature temperature;
    private final TemperatureEventType type;

    /**
     * Constructor initializes the temperature event.
     *
     * @param source      The object that generated the event.
     * @param temperature The Temperature associated with the event.
     * @param type        The type of the event (MINIMUM or MAXIMUM).
     */
    public TemperatureEvent(Object source, Temperature temperature, TemperatureEventType type) {
        super(source);
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
