package U08_EX_CollectionsEnumsStatic.temperatur.temperature;

import java.util.Objects;


/**
 * Represents a temperature object with methods for unit conversions.
 *
 * @author Philipp Schhüpach
 * @version 1.0.0
 * @use Use this class to create temperature objects in Celsius and convert between Kelvin and Fahrenheit.
 */
@SuppressWarnings({"unused", "ClassCanBeRecord"})
public final class Temperature implements Comparable<Temperature>{

    public final static double KELVIN_OFFSET = 273.15;
    private final double celsius;

    /**
     * Constructs a Temperature Object with a Celsius value.
     * It also checks if the given Celsius value is below -273.15°C and throws an error if it is the case
     * @param celsius the temperature to set in Celsius
     */
    public Temperature(double celsius) {
        if (celsius < -KELVIN_OFFSET){
            throw new IllegalArgumentException("Temperature cannot be below -273.15°C.");
        }
        this.celsius = celsius;
    }

    /**
     *  Get new Temperature with adjusted Celsius temperature
     *  The input can be in Celsius or kelvin
     * @param deltaTemperature in celsius
     */
    public Temperature getNewTemperatureInCelsius(double deltaTemperature) {
        return new Temperature(this.celsius +deltaTemperature);
    }

    /**
     * Get the Temperature in Celsius
     * @return celsius in celsius
     */
    public double getCelsius() {
        return celsius;
    }

    /**
     * Get a new temperature set from kelvin
     * @param kelvin temperature in kelvin
     */
    public Temperature setTemperatureFromKelvin(double kelvin) {
        return new Temperature(kelvinToCelsius(kelvin));
    }

    /**
     * Get a new temperature set from Fahrenheit
     * @param fahrenheit temperature in fahrenheit
     */
    public Temperature setTemperatureFromFahrenheit(double fahrenheit) {
        return new Temperature((fahrenheit - 32) / 1.8);
    }

    /**
     * converts the given Celsius temperature to kelvin and returns it.
     * @param celsius the Celsius temperature to convert
     * @return the temperature in klevin
     */

    public static double celsiusToKelvin(double celsius){
        if (celsius < -KELVIN_OFFSET){
            throw new IllegalArgumentException("Temperature cannot be below -273.15°C.");
        }

        return Math.round((celsius + KELVIN_OFFSET) * 100.0) / 100.0;
    }

    /**
     * converts the given Kelvin temperature to Celsius and returns it.
     * @param kelvin the Kelvin temperature to convert
     * @return the temperature in Celsius
     */

    public static double kelvinToCelsius(double kelvin){
        if (kelvin < 0){
            throw new IllegalArgumentException("Temperature cannot be below 0 Kelvin.");
        }
        return Math.round((kelvin - KELVIN_OFFSET) * 100.0) / 100.0;
    }

    /**
     * converts the current Celsius temperature to kelvin and returns it.
     * @return celsius in kelvin
     */
    public double toKelvin(){
        return Math.round((celsiusToKelvin(celsius)) * 100.0) / 100.0;
    }

    /**
     * converts the current Celsius temperature to Fahrenheit and returns it
     * @return celsius in fahrenheit
     */
    public double toFahrenheit(){
        return Math.round((celsius * 1.8 + 32.0) * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Temperature t)) return false;
        return Double.compare(t.celsius, celsius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash((int) (celsius * 10000)); // Scale for precision
    }

    @Override
    public int compareTo(Temperature o) {
        return Double.compare(this.celsius, o.celsius);
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "celsius=" + celsius +
                ", kelvin=" + toKelvin() +
                ", fahrenheit=" + toFahrenheit() +
                '}';
    }
}
