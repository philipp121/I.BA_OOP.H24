package U10_EX_Eventhandling.temperatur;

/**
 * Listener interface for receiving temperature change events.
 * Classes interested in processing temperature events should implement this interface.
 */
@FunctionalInterface
public interface TemperatureEventListener {
    /**
     * Invoked when a temperature change event occurs.
     *
     * @param event the TemperatureEvent object containing event details.
     */
    void onTemperatureEvent(TemperatureEvent event);
}
