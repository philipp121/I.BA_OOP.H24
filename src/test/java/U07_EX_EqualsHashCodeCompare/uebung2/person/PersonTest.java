package U07_EX_EqualsHashCodeCompare.uebung2.person;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    protected Person p1;
    protected Person p2;

    @BeforeEach
    void setUp() {
        p1 = null;
        p2 = null;
    }

    @Test
    void PersonOnlyID(){
        p1 = new Person(114);
        assertEquals(114, p1.getId());
    }

    @Test
    void PersonAllAttributes(){
        p1 = new Person(4594, "Muster", "Hans");
        assertEquals(4594, p1.getId());
        assertEquals("Muster", p1.getName());
        assertEquals("Hans", p1.getSurname());
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Person.class)
                .withOnlyTheseFields("id")
                .verify();
    }

    @Test
    void equalsTrue(){
        p1 = new Person(4654, "Peter", "Müller");
        p2 = new Person(4654, "Peter", "Müller");
        assertTrue(p1.equals(p2));
    }

    @Test
    void equalsFalse(){
        p1 = new Person(5673, "Daniel", "Albisser");
        p2 = new Person(8573, "John", "Doe");
        assertFalse(p1.equals(p2));
    }

    @Test
    void equalsWithNull() {
        p1 = new Person(1234, "Jane", "Doe");
        assertFalse(p1.equals(null));
    }

    @Test
    void equalsWithDifferentClass() {
        p1 = new Person(1234, "Jane", "Doe");
        String other = "Not a Person";
        assertFalse(p1.equals(other));
    }

    @Test
    void equalsDifferentAttributes() {
        p1 = new Person(1234, "John", "Doe");
        p2 = new Person(1234, "Jane", "Smith");
        assertTrue(p1.equals(p2));
    }

    @Test
    void hashCodeSameTrue(){
        p1 = new Person(3245, "Susan", "Albricht");
        p2 = new Person(3245, "Susan", "Albricht");
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void hashCodeSameFalse(){
        p1 = new Person(3245, "Susan", "Albricht");
        p2 = new Person(4756, "Christine", "Sutter");
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }
    
    @Test
    void compareToIsEqual(){
        p1 = new Person(3245, "Susan", "Albricht");
        p2 = new Person(3245, "Susan", "Albricht");
        assertEquals(0, p1.compareTo(p2));
        assertEquals(0, p2.compareTo(p1));
    }

    @Test
    void compareToLessThan(){
        p1 = new Person(5673, "Daniel", "Albisser");
        p2 = new Person(8573, "John", "Doe");
        assertEquals(-1, p1.compareTo(p2));
    }

    @Test
    void compareToGreaterThan(){
        p1 = new Person(1234, "John", "Doe");
        p2 = new Person(234, "Jane", "Smith");
        assertEquals(1, p1.compareTo(p2));
    }

    @Test
    void compareToNull() {
        p1 = new Person(1234, "John", "Doe");
        assertThrows(NullPointerException.class, () -> p1.compareTo(null));
    }

    @Test
    void compareToSymmetry() {
        p1 = new Person(5673, "Daniel", "Albisser");
        p2 = new Person(8573, "John", "Doe");
        assertEquals(-1, p1.compareTo(p2));
        assertEquals(1, p2.compareTo(p1));
    }

    @Test
    void compareToConsistency() {
        p1 = new Person(1234, "John", "Doe");
        p2 = new Person(234, "Jane", "Smith");
        assertEquals(1, p1.compareTo(p2));
        assertEquals(1, p1.compareTo(p2)); // Same result expected
    }

    @Test
    void compareToTransitivity() {
        p1 = new Person(1234, "A", "B");
        p2 = new Person(2345, "C", "D");
        Person p3 = new Person(3456, "E", "F");

        assertTrue(p1.compareTo(p2) < 0);
        assertTrue(p2.compareTo(p3) < 0);
        assertTrue(p1.compareTo(p3) < 0);
    }

    @Test
    void compareToMultipleFields() {
        p1 = new Person(1234, "John", "Doe");
        p2 = new Person(1234, "Jane", "Doe");
        Person p3 = new Person(1234, "John", "Smith");

        assertTrue(p1.compareTo(p2) ==  0); // Compare "John" vs "Jane"
        assertTrue(p1.compareTo(p3) == 0); // Compare "Doe" vs "Smith"
    }

    @Test
    void compareToEdgeCase() {
        p1 = new Person(0, "Zero", "Person");
        p2 = new Person(Integer.MAX_VALUE, "Max", "Person");
        assertTrue(p1.compareTo(p2) < 0);
    }
}