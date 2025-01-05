package U07_EX_EqualsHashCodeCompare.uebung2.temperatur;

import java.util.Objects;

public final class Temperature implements Comparable<Temperature>{

    private final double temperature;

    public Temperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * Checks the Element type and then calls calculateState with lower and higher temperature values
     * to get the Aggregate State
     * @param element the element to check for the current aggregate State
     * @return the Aggregate State of the element in question
     */
    public String getElementAggregateState(String element){
        return switch (element) {
            case "N" -> calculateState(-210.0, -196.0);
            case "Hg" -> calculateState(-39.0, 357.0);
            case "Pb" -> calculateState(327.5, 1749);
            default -> throw new IllegalArgumentException("Element not implemented: " + element);
        };
    }

    /**
     * Calculates the State according to low and high temperatures values. If the temperature is higher
     * then the high end it returns gaseous as default
     * @param low the low temperature
     * @param high the high temperature
     * @return the Aggregate State as String
     */
    private String calculateState(double low, double high){
        if (temperature < low){
            return "solid";
        } else if (temperature < high){
            return "liquid";
        } else {
            return "gaseous";
        }
    }

    /**
     * Adjust temperature celsius with a celsius value
     * @param deltaCelsius in celsius
     */
    public Temperature adjustTemperatureInCelsius(double deltaCelsius){
        return new Temperature(this.temperature +deltaCelsius);
    }

    /**
     * Adjust the temperature celsius with a kelvin value and make sure kelvin can not be below zero
     * @param deltaKelvin
     */
    public Temperature adjustTemperatureInKelvin(double deltaKelvin){
        double currentKelvin = this.temperature + 273.15;
        double newKelvin = currentKelvin + deltaKelvin;

        if (newKelvin < 0) {
            throw new IllegalArgumentException("Resulting temperature in Kelvin cannot be below 0.");
        }

        return new Temperature(newKelvin - 273.15);
    }

    /**
     * converts celsius to kelvin and return it. If temperature is below -273.15, an error is thrown
     * since kelvin can't be below zero
     * @return temperature in kelvin
     */
    public double toKelvin(){
        if (temperature < -273.15) {
            throw new IllegalArgumentException("Temperature in Kelvin cannot be negative.");
        }
        return Math.round((temperature + 273.15) * 100.0) / 100.0;
    }

    /**
     * converts celsius to fahrenheit and return it
     * @return temperature in fahrenheit
     */
    public double toFahrenheit(){
        return Math.round((temperature * 1.8 + 32.0) * 100.0) / 100.0;
    }

    /**
     * Get the temperature in celsius
     * @return temperature in celsius
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Sets the temperature in celsius with an kelvin value input
     * @param kelvin temperature in kelvin
     */
    public Temperature setTemperatureFromKelvin(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Temperature in Kelvin cannot be negative.");
        }
        return new Temperature(kelvin - 273.15);
    }

    /**
     * Sets the temperature in celsius with an fahrenheit value input
     * @param fahrenheit temperature in fahrenheit
     */
    public Temperature setTemperatureFromFahrenheit(double fahrenheit) {
        return new Temperature((fahrenheit - 32) / 1.8);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Temperature)) return false;
        Temperature t = (Temperature) o;
        return Double.compare(t.temperature, temperature) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash((int) (temperature * 10000)); // Scale for precision
    }

    @Override
    public int compareTo(Temperature o) {
        return Double.compare(this.temperature, o.temperature);
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "temperature=" + temperature +
                '}';
    }
}
