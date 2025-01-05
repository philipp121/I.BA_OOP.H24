package U07_EX_EqualsHashCodeCompare.uebung2.point;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    private Point point1;
    private Point point2;

    @BeforeEach
    void setUp() {
        point1 = null;
        point2 = null;
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Point.class).verify();
    }

    @Test
    void testEqualsTrue() {
        point1 = new Point(10, 15);
        point2 = new Point(10, 15);
        assertTrue(point1.equals(point2));
    }

    @Test
    void testEqualsFalse() {
        point1 = new Point(25, 13);
        point2 = new Point(56, 5);
        assertFalse(point1.equals(point2));
    }

    @Test
    void equalsWithNull() {
        point1 = new Point(43, 65);
        assertFalse(point1.equals(null));
    }

    @Test
    void equalsReversedFalse() {
        point1 = new Point(65, 56);
        point2 = new Point(56, 65);
        assertNotEquals(point1, point2);
    }

    @Test
    void equalsWithDifferentClass() {
        point1 = new Point(8, 17);
        String other = "Not a Point";
        assertFalse(point1.equals(other));
    }

    @Test
    void hashCodeSameTrue(){
        point1 = new Point(56, 107);
        point2 = new Point(56, 107);
        assertEquals(point1.hashCode(), point2.hashCode());
    }

    @Test
    void hashCodeSameFalse(){
        point1 = new Point(34, 107);
        point2 = new Point(56, 65);
        assertNotEquals(point1.hashCode(), point2.hashCode());
    }

    @Test
    void hashCodeReversedFalse(){
        point1 = new Point(65, 56);
        point2 = new Point(56, 65);
        assertNotEquals(point1.hashCode(), point2.hashCode());
    }
}