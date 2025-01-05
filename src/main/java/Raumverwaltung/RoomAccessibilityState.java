package Raumverwaltung;

/**
 * Represents the accessibility state of a Room: free, reserved, and blocked.
 * Each state is associated with a human-readable description.
 *
 * @author Philipp Schüpbach
 * @version 1.0.0
 * @use Use this enum to represent room accessibility states in room reservation applications.
 */
public enum RoomAccessibilityState {
    /** A state that describes the accessibility of a Room as free*/
    FREE("Free"),
    /** A state that describes the accessibility of a Room as reserved*/
    RESERVED("Reserved"),
    /** A state that describes the accessibility of a Room as blocked*/
    BLOCKED("Blocked");

    private final String description;

    RoomAccessibilityState(String description) {
        this.description = description;
    }

    /**
     * Retrieves the human-readable description of the room accessibility state.
     *
     * @return the description of the state (e.g., "Free", "Reserved").
     */
    public String getDescription() {
        return description;
    }

    /**
     * Finds a Room accessibility state by its description.
     * <p>
     * This method is case-sensitive, meaning the provided description must match
     * exactly (including case) with the enum constant's description.
     * </p>
     *
     * @param description the human-readable description of the room state
     * @return the corresponding RoomState
     * @throws IllegalArgumentException if the description does not match any state
     */
    public static RoomAccessibilityState fromDescription(String description) {
        for (RoomAccessibilityState state : RoomAccessibilityState.values()) {
            if (state.getDescription().equalsIgnoreCase(description)) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown Room state description: " + description);
    }

    @Override
    public String toString() {
        return "RoomState{" +
                "description='" + description + '\'' +
                '}';
    }
}
