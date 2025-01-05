package U08_EX_CollectionsEnumsStatic.temperatur.temperature;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Represents a temperature history that stores and processes temperature records.
 *
 * @author Philipp Schhüpach
 * @version 1.0.0
 * @use Use this class to manage a collection of temperatures, find min/max/average,
 *      or perform operations like clearing and replacing data.
 */
public final class TemperatureHistory  {
    private final List<Temperature> temperatures;

    /**
     * Initializes an empty history of temperatures.
     */
    public TemperatureHistory() {
        this.temperatures = new ArrayList<>();
    }

    /**
     * Adds a temperature to the history.
     *
     * @param temperature the temperature to add
     * @throws NullPointerException if the provided temperature is {@code null}
     */
    public void addTemperature(Temperature temperature){
        if (temperature == null) {
            throw new NullPointerException("Temperature cannot be null");
        }
        this.temperatures.add(temperature);
    }

    /**
     * Clears all temperatures from the history.
     */
    public void clear(){
        this.temperatures.clear();
    }

    /**
     * Adds all temperatures from the provided list to the history.
     *
     * @param temperatures the list of temperatures to add
     * @throws NullPointerException if the provided list is {@code null}
     */
        public void addTemperatures(List<Temperature> temperatures){
        if (temperatures == null) {
            throw new NullPointerException("Temperatures list cannot be null");
        }
        this.temperatures.addAll(temperatures);
    }

    /**
     * Replaces the current history with a new list of temperatures.
     *
     * @param newTemperatures the new list of temperatures to set as the history
     * @throws NullPointerException if the provided list is {@code null}
     */
    public void replaceTemperatures(List<Temperature> newTemperatures){
        if (newTemperatures == null) {
            throw new NullPointerException("Temperatures list cannot be null");
        }
        this.clear();
        this.addTemperatures(newTemperatures);
    }

    /**
     * Retrieves the number of temperatures in the history.
     *
     * @return the size of the history
     */
    public int getCount(){
        return this.temperatures.size();
    }

    /**
     * Finds the extreme (minimum or maximum) temperature in the history
     * based on the provided comparator.
     *
     * @param comparator the comparator used to determine the extreme value.
     *                   For example, use {@link Comparator#naturalOrder()} to find the minimum,
     *                   or {@link Comparator#reverseOrder()} to find the maximum.
     * @return the extreme temperature based on the comparator, or {@code null} if the history is empty
     */
    private Temperature findExtreme(Comparator<Temperature> comparator) {
        return this.temperatures.stream()
                .min(comparator)
                .orElse(null);
    }

    /**
     * Retrieves the highest temperature in the history.
     *
     * @return the highest temperature in the history, or {@code null} if the history is empty.
     * Uses the reverse order of temperatures to determine the maximum value.
     */
    public Temperature getMaxTemperature(){
        return findExtreme(Comparator.reverseOrder());
    }

    /**
     * Retrieves the lowest temperature in the history.
     *
     * @return the lowest temperature in the history, or {@code null} if the history is empty.
     * Uses the natural order of temperatures to determine the minimum value.
     */
    public Temperature getMinTemperature(){
        return findExtreme(Comparator.naturalOrder());
    }

    /**
     * Calculates the average temperature of all values in the history.
     *
     * @return a {@code Temperature} object representing the average temperature,
     *         or {@code null} if the history is empty.
     */
    public Temperature getAverageTemperature(){
        double averageCelsius = temperatures.stream()
                .mapToDouble(Temperature::getCelsius)
                .average()
                .orElse(Double.NaN);

        return Double.isNaN(averageCelsius) ? null : new Temperature(averageCelsius);
    }

    /**
     * Returns an unmodifiable copy of the current history list.
     *
     * @return a read-only copy of the history list
     */
    public List<Temperature> getTemperatures() {
        return List.copyOf(temperatures);
    }

    /**
     * Compares this temperature history with another for equality.
     *
     * @param o the object to compare with
     * @return {@code true} if the histories are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemperatureHistory th)) return false;
        return Objects.equals(this.temperatures, th.temperatures);
    }

    /**
     * Computes the hash code for this temperature history.
     *
     * @return the hash code of the history
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(this.temperatures);
    }

    /**
     * Provides a single-line string representation of the temperature history.
     *
     * @return a single-line string representation of the temperature history,
     *         or "No temperatures recorded" if the history is empty.
     */
    @Override
    public String toString() {
        return "TemperatureHistory: " + temperatures.stream()
                .map(Temperature::toString)
                .reduce((a, b) -> a + ", " + b)
                .orElse("No temperatures recorded");
    }

    /**
     * Provides a multi-line string representation of the temperature history.
     *
     * @return a multi-line string representation of the temperature history,
     *         or "No temperatures recorded" if the history is empty.
     */
    public String toFormattedString() {
        return "TemperatureHistory{\n" +
                "  temperatures=\n    " +
                temperatures.stream()
                        .map(Temperature::toString)
                        .reduce((a, b) -> a + ",\n    " + b)
                        .orElse("No temperatures recorded") +
                "\n}";
    }
}
