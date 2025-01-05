package U07_EX_EqualsHashCodeCompare.uebung1.temperatur;

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
}