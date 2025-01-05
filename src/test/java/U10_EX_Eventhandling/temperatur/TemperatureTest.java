package U10_EX_Eventhandling.temperatur;

import U09_EX_ExceptionsLogging.uebung2.temperature.Temperature;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SimplifiableAssertion")
class TemperatureTest {

    private U09_EX_ExceptionsLogging.uebung2.temperature.Temperature t1;
    private U09_EX_ExceptionsLogging.uebung2.temperature.Temperature t2;

    @BeforeEach
    void setUp() {
        t1 = null;
        t2 = null;
    }

    @Test
    void testConstructorThrowsExceptionForInvalidTemperature() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(-275.15));
        assertEquals("Temperature cannot be below -273.15°C.", exception.getMessage());
    }

    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass( U09_EX_ExceptionsLogging.uebung2.temperature.Temperature.class).verify();
    }

    @Test
    void testEqualsTrue() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(20);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(20);
        assertTrue(t1.equals(t2));
    }

    @Test
    void testEqualsFalse() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(14);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(65);
        assertFalse(t1.equals(t2));
    }

    @Test
    void testVeryLowTemperature() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(-273.15);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(-273.15);
        assertTrue(t1.equals(t2));
    }

    @Test
    void testVeryHighTemperature() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(1e6);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(1e6);
        assertTrue(t1.equals(t2));
    }

    @Test
    void testEqualsWithPrecisionTrue() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(39.00001);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(39.00001);
        assertTrue(t1.equals(t2));
    }

    @Test
    void testEqualsWithPrecisionFalse() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(20.00001);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(20.00002);
        assertFalse(t1.equals(t2));
    }

    @SuppressWarnings("EqualsBetweenInconvertibleTypes")
    @Test
    void testEqualsWithDifferentClass() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(14);
        String other = "Not a Temperature";
        assertFalse(t1.equals(other));
    }

    @SuppressWarnings("ConstantValue")
    @Test
    void testEqualsWithNull() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(40);
        assertFalse(t1.equals(null));
    }

    @Test
    void testHashCodeSameTrue(){
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(34);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(34);
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testHashCodeSameFalse(){
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(13);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(25);
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testHashCodeWithPrecision() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(20.00001);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(20.00002);
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testCompareToIsEqual(){
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(34);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(34);
        assertEquals(0, t1.compareTo(t2));
        assertEquals(0, t2.compareTo(t1));
    }

    @Test
    void testCompareToLessThan(){
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(14);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(65);
        assertEquals(-1, t1.compareTo(t2));
    }

    @Test
    void testCompareToGreaterThan(){
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(104);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(65);
        assertEquals(1, t1.compareTo(t2));
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testCompareToNull() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(33);
        assertThrows(NullPointerException.class, () -> t1.compareTo(null));
    }

    @Test
    void testCompareToSymmetry() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(54);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(91);
        assertEquals(-1, t1.compareTo(t2));
        assertEquals(1, t2.compareTo(t1));
    }

    @Test
    void testCompareToConsistency() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(29);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(22);
        assertEquals(1, t1.compareTo(t2));
        assertEquals(1, t1.compareTo(t2)); // Same result expected
    }

    @Test
    void testCompareToTransitivity() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(18);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(35);
        U09_EX_ExceptionsLogging.uebung2.temperature.Temperature t3 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(44);

        assertTrue(t1.compareTo(t2) < 0);
        assertTrue(t2.compareTo(t3) < 0);
        assertTrue(t1.compareTo(t3) < 0);
    }

    @Test
    void testCompareToMultipleFields() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(18);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(18);
        U09_EX_ExceptionsLogging.uebung2.temperature.Temperature t3 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(18);

        assertTrue(t1.compareTo(t2) == 0); // Compare "John" vs "Jane"
        assertTrue(t1.compareTo(t3) == 0); // Compare "Doe" vs "Smith"
    }

    @Test
    void testCompareToEdgeCase() {
        t1 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(-273.15);
        t2 = new U09_EX_ExceptionsLogging.uebung2.temperature.Temperature(Integer.MAX_VALUE);
        assertTrue(t1.compareTo(t2) < 0);
    }

    @Test
    void testCelsiusToKelvinHigh(){
        assertEquals(500,  U09_EX_ExceptionsLogging.uebung2.temperature.Temperature.celsiusToKelvin(226.85));
    }

    @Test
    void testCelsiusToKelvinLow(){
        assertEquals(0,  U09_EX_ExceptionsLogging.uebung2.temperature.Temperature.celsiusToKelvin(-273.15));
    }

    @Test
    void testCelsiusToKelvinThrowsExceptionForInvalidTemperature() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> U09_EX_ExceptionsLogging.uebung2.temperature.Temperature.celsiusToKelvin(-274));
        assertEquals("Temperature cannot be below -273.15°C.", exception.getMessage());
    }

    @Test
    void testKelvinToCelsiusLow(){
        assertEquals(-273.15,  U09_EX_ExceptionsLogging.uebung2.temperature.Temperature.kelvinToCelsius(0));
    }

    @Test
    void testKelvinToCelsiusHigh(){
        assertEquals(226.85,  U09_EX_ExceptionsLogging.uebung2.temperature.Temperature.kelvinToCelsius(500));
    }

    @Test
    void testKelvinToCelsiusThrowsExceptionForInvalidTemperatur(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Temperature.kelvinToCelsius(-1));
        assertEquals("Temperature cannot be below 0 Kelvin.", exception.getMessage());
    }
}
