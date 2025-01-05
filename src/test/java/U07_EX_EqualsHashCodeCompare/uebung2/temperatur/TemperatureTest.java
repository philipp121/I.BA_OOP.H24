package U07_EX_EqualsHashCodeCompare.uebung2.temperatur;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    private Temperature t1;
    private Temperature t2;

    @BeforeEach
    void setUp() {
        t1 = null;
        t2 = null;
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Temperature.class).verify();
    }

    @Test
    void testEqualsTrue() {
        t1 = new Temperature(20);
        t2 = new Temperature(20);
        assertTrue(t1.equals(t2));
    }

    @Test
    void testEqualsFalse() {
        t1 = new Temperature(14);
        t2 = new Temperature(65);
        assertFalse(t1.equals(t2));
    }

    @Test
    void testVeryLowTemperature() {
        t1 = new Temperature(-273.15);
        t2 = new Temperature(-273.15);
        assertTrue(t1.equals(t2));
    }

    @Test
    void testVeryHighTemperature() {
        t1 = new Temperature(1e6);
        t2 = new Temperature(1e6);
        assertTrue(t1.equals(t2));
    }

    @Test
    void testEqualsWithPrecisionTrue() {
        t1 = new Temperature(39.00001);
        t2 = new Temperature(39.00001);
        assertTrue(t1.equals(t2));
    }

    @Test
    void testEqualsWithPrecisionFalse() {
        t1 = new Temperature(20.00001);
        t2 = new Temperature(20.00002);
        assertFalse(t1.equals(t2));
    }

    @Test
    void equalsWithDifferentClass() {
        t1 = new Temperature(14);
        String other = "Not a Temperature";
        assertFalse(t1.equals(other));
    }

    @Test
    void equalsWithNull() {
        t1 = new Temperature(40);
        assertFalse(t1.equals(null));
    }

    @Test
    void hashCodeSameTrue(){
        t1 = new Temperature(34);
        t2 = new Temperature(34);
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void hashCodeSameFalse(){
        t1 = new Temperature(13);
        t2 = new Temperature(25);
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testHashCodeWithPrecision() {
        t1 = new Temperature(20.00001);
        t2 = new Temperature(20.00002);
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void compareToIsEqual(){
        t1 = new Temperature(34);
        t2 = new Temperature(34);
        assertEquals(0, t1.compareTo(t2));
        assertEquals(0, t2.compareTo(t1));
    }

    @Test
    void compareToLessThan(){
        t1 = new Temperature(14);
        t2 = new Temperature(65);
        assertEquals(-1, t1.compareTo(t2));
    }

    @Test
    void compareToGreaterThan(){
        t1 = new Temperature(104);
        t2 = new Temperature(65);
        assertEquals(1, t1.compareTo(t2));
    }

    @Test
    void compareToNull() {
        t1 = new Temperature(33);
        assertThrows(NullPointerException.class, () -> t1.compareTo(null));
    }

    @Test
    void compareToSymmetry() {
        t1 = new Temperature(54);
        t2 = new Temperature(91);
        assertEquals(-1, t1.compareTo(t2));
        assertEquals(1, t2.compareTo(t1));
    }

    @Test
    void compareToConsistency() {
        t1 = new Temperature(29);
        t2 = new Temperature(22);
        assertEquals(1, t1.compareTo(t2));
        assertEquals(1, t1.compareTo(t2)); // Same result expected
    }

    @Test
    void compareToTransitivity() {
        t1 = new Temperature(18);
        t2 = new Temperature(35);
        Temperature t3 = new Temperature(44);

        assertTrue(t1.compareTo(t2) < 0);
        assertTrue(t2.compareTo(t3) < 0);
        assertTrue(t1.compareTo(t3) < 0);
    }

    @Test
    void compareToMultipleFields() {
        t1 = new Temperature(18);
        t2 = new Temperature(18);
        Temperature t3 = new Temperature(18);

        assertTrue(t1.compareTo(t2) == 0); // Compare "John" vs "Jane"
        assertTrue(t1.compareTo(t3) == 0); // Compare "Doe" vs "Smith"
    }

    @Test
    void compareToEdgeCase() {
        t1 = new Temperature(Integer.MIN_VALUE);
        t2 = new Temperature(Integer.MAX_VALUE);
        assertTrue(t1.compareTo(t2) < 0);
    }
}