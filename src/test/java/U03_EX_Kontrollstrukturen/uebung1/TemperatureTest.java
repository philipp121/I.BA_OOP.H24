package U03_EX_Kontrollstrukturen.uebung1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TemperatureTest {

    private Temperature temperature;

    @BeforeEach
    void setUp() {
        temperature = new Temperature(0.00);
    }

    @Test
    void adjustTemperatureCelsiusMin(){
        temperature.setTemperature(-20.00);
        temperature.adjustTemperatureInCelsius(-253.15);
        assertEquals(-273.15, temperature.getTemperature(), 0.001);
    }

    @Test
    void adjustTemperatureCelsiusMax(){
        temperature.setTemperature(41.00);
        temperature.adjustTemperatureInCelsius(185.85);
        assertEquals(226.85, temperature.getTemperature(), 0.001);
    }

    @Test
    void adjustTemperatureCelsiusZero(){
        temperature.setTemperature(67.00);
        temperature.adjustTemperatureInCelsius(0.00);
        assertEquals(67.00, temperature.getTemperature(), 0.001);
    }

    @Test
    void adjustTemperatureInKelvinMin(){
        temperature.setTemperature(-203.15);
        temperature.adjustTemperatureInKelvin(-65.00);
        assertEquals(-268.15, temperature.getTemperature(), 0.001);
    }

    @Test
     void adjustTemperatureInKelvinMax(){
        temperature.setTemperature(40.00);
        temperature.adjustTemperatureInKelvin(290.65);
        assertEquals(330.65, temperature.getTemperature(), 0.001);
    }

    @Test
    void adjustTemperatureInKelvinBoundary() {
        temperature.setTemperature(-273.15); // 0 Kelvin
        temperature.adjustTemperatureInKelvin(0.001); // Just above absolute zero
        assertEquals(-273.149, temperature.getTemperature(), 0.001);
    }

    @Test
    void adjustTemperatureInKelvinAbsoluteZero(){
        temperature.setTemperature(-273.15);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> temperature.adjustTemperatureInKelvin(-1.00)
        );
        assertEquals("Resulting temperature in Kelvin cannot be below 0.", exception.getMessage());
    }

    @Test
    void multipleAdjustments() {
        temperature.setTemperature(20.00);
        temperature.adjustTemperatureInCelsius(-10.00);
        temperature.adjustTemperatureInKelvin(-5.00);
        assertEquals(5.00, temperature.getTemperature(), 0.001);
    }

    @Test
    void toKelvinMax() {
        temperature.setTemperature(226.85);
        assertEquals(500.00, temperature.toKelvin(), 0.001);
    }

    @Test
    void toKelvinMin() {
        temperature.setTemperature(-273.15);
        assertEquals(0.00, temperature.toKelvin(), 0.001);
    }

    @Test
    void toKelvinZero() {
        temperature.setTemperature(0.00);
        assertEquals(273.15, temperature.toKelvin(), 0.001);
    }

    @Test
    void toKelvinRoundingTest() {
        temperature.setTemperature(-272.949); // Should round down
        assertEquals(0.20, temperature.toKelvin(), 0.001);

        temperature.setTemperature(-272.151); // Should round up
        assertEquals(1.00, temperature.toKelvin(), 0.001);
    }

    @Test
    void toKelvinBelowAbsoluteZero() {
        temperature.setTemperature(-300.00);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> temperature.toKelvin()
        );
        assertEquals("Temperature in Kelvin cannot be negative.", exception.getMessage());
    }

    @Test
    void toFahrenheitMax() {
        temperature.setTemperature(226.85);
        assertEquals(440.33, temperature.toFahrenheit(), 0.001);
    }

    @Test
    void toFahrenheitMin() {
        temperature.setTemperature(-273.15);
        assertEquals(-459.67, temperature.toFahrenheit(), 0.001);
    }

    @Test
    void toFahrenheitZero() {
        temperature.setTemperature(0.00);
        assertEquals(32.00, temperature.toFahrenheit(), 0.001);
    }

    @Test
    void setTemperatureFromKelvinMin() {
        temperature.setTemperatureFromKelvin(500.00);
        assertEquals(226.85, temperature.getTemperature(), 0.001);
    }

    @Test
    void setTemperatureFromKelvinMax() {
        temperature.setTemperatureFromKelvin(0.00);
        assertEquals(-273.15, temperature.getTemperature(), 0.001);
    }

    @Test
    void setTemperatureFromKelvinZero() {
        temperature.setTemperatureFromKelvin(273.15);
        assertEquals(0.00, temperature.getTemperature(), 0.001);
    }

    @Test
    void setTemperatureFromKelvinAbsoluteZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> temperature.setTemperatureFromKelvin(-300.00)
        );
        assertEquals("Temperature in Kelvin cannot be negative.", exception.getMessage());
    }

    @Test
    void setTemperatureFromFahrenheitMin() {
        temperature.setTemperatureFromFahrenheit(440.33);
        assertEquals(226.85, temperature.getTemperature(), 0.001);
    }

    @Test
    void setTemperatureFromFahrenheitMax() {
        temperature.setTemperatureFromFahrenheit(-459.67);
        assertEquals(-273.15, temperature.getTemperature(), 0.001);
    }

    @Test
    void setTemperatureFromFahrenheitZero() {
        temperature.setTemperatureFromFahrenheit(0.00);
        assertEquals(-17.77777777777778, temperature.getTemperature(), 0.001);
    }
}