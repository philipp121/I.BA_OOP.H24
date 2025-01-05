package U02_EX_KlassenDatentypen.uebung1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperaturComplicatedTest {

    private Temperature_Complicated temperatur;

    @BeforeEach
    void setUp() {
        temperatur = new Temperature_Complicated();
    }

    @Test
    void celsiusToKelvinMax() {
        assertEquals(500.00, temperatur.celsiusToKelvin(226.85));
    }

    @Test
    void celsiusToKelvinMin() {
        assertEquals(0.00, temperatur.celsiusToKelvin(-273.15));
    }

    @Test
    void celsiusToKelvinZero() {
        assertEquals(273.15, temperatur.celsiusToKelvin(0.00));
    }

    @Test
    void kelvinToCelsiusMax() {
        assertEquals(226.85, temperatur.kelvinToCelsius(500.00));
    }

    @Test
    void kelvinToCelsiusMin() {
        assertEquals(-273.15, temperatur.kelvinToCelsius(0.00));
    }

    @Test
    void kelvinToCelsiusZero() {
        assertEquals(0.00, temperatur.kelvinToCelsius(273.15));
    }

    @Test
    void celsiusToFahrenheitMax() {
        assertEquals(440.33, temperatur.celsiusToFahrenheit(226.85));
    }

    @Test
    void celsiusToFahrenheitMin() {
        assertEquals(-459.67, temperatur.celsiusToFahrenheit(-273.15));
    }

    @Test
    void celsiusToFahrenheitZero() {
        assertEquals(32.00, temperatur.celsiusToFahrenheit(0.00));
    }

    @Test
    void fahrenheitToCelsiusMax() {
        assertEquals(226.85, temperatur.fahrenheitToCelsius(440.33));
    }

    @Test
    void fahrenheitToCelsiusMin() {
        assertEquals(-273.15, temperatur.fahrenheitToCelsius(-459.67));
    }

    @Test
    void fahrenheitToCelsiusZero() {
        assertEquals(-17.78, temperatur.fahrenheitToCelsius(0.00));
    }
}