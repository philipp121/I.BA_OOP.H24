package U08_EX_CollectionsEnumsStatic.element;

/**
 * Represents the states of matter: solid, liquid, and gas.
 * Each state is associated with a human-readable description.
 *
 * @author Philipp Schüpbach
 * @version 1.0.0
 * @use Use this enum to represent aggregate states in physics or chemistry applications.
 */
public enum AggregateState {

    /** A state with a definite shape and volume. */
    SOLID("Solid"),
    /** A state with a definite volume but no fixed shape. */
    LIQUID("Liquid"),
    /** A state with no fixed shape or volume. */
    GAS("Gaseous");

    private final String description;

    AggregateState(String description) {
        this.description = description;
    }

    /**
     * Retrieves the human-readable description of the aggregate state.
     *
     * @return the description of the state (e.g., "Solid", "Liquid").
     */
    public String getDescription(){
        return description;
    }

    /**
     * Finds an AggregateState by its description.
     * <p>
     * This method is case-sensitive, meaning the provided description must match
     * exactly (including case) with the enum constant's description.
     * </p>
     *
     * @param description the human-readable description of the state
     * @return the corresponding AggregateState
     * @throws IllegalArgumentException if the description does not match any state
     */
    public static AggregateState fromDescription(String description) {
        for (AggregateState state : AggregateState.values()) {
            if (state.getDescription().equalsIgnoreCase(description)) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown description: " + description);
    }

    @Override
    public String toString() {
        return description;
    }
}
