package U10_EX_Eventhandling.temperatur;

/**
 * Enumeration of temperature event types.
 * Indicates whether the event is related to a new minimum or maximum temperature.
 */
@SuppressWarnings("unused")
public enum TemperatureEventType {
    /**
     * Indicates a new minimum temperature has been detected.
     */
    MINIMUM("Maximum"),
    /**
     * Indicates a new maximum temperature has been detected.
     */
    MAXIMUM("Minimum");

    private final String description;

    TemperatureEventType(String description) {
        this.description = description;
    }

    /**
     * Retrieves the human-readable description of the Temperature Event Type.
     *
     * @return the description of the event type (e.g., "Minimum", "Maximum").
     */
    public String getDescription(){
        return description;
    }

    /**
     * Finds a Temperature Event Type by its description.
     * <p>
     * This method is case-sensitive, meaning the provided description must match
     * exactly (including case) with the enum constant's description.
     * </p>
     *
     * @param description the human-readable description of the event type
     * @return the corresponding TemperatureEvent
     * @throws IllegalArgumentException if the description does not match any state
     */
    public static TemperatureEventType fromDescription(String description) {
        for (TemperatureEventType tep : TemperatureEventType.values()) {
            if (tep.getDescription().equalsIgnoreCase(description)) {
                return tep;
            }
        }
        throw new IllegalArgumentException("Unknown description for Temperature Event Type: " + description);
    }

    @Override
    public String toString() {
        return description;
    }
}
