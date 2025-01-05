package U07_EX_EqualsHashCodeCompare.uebung1.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import nl.jqno.equalsverifier.*;

class PersonTest {

    protected Person person;

    @BeforeEach
    void setUp() {
        person = null;
    }

    @Test
    void PersonOnlyID(){
        person = new Person(114);
        assertEquals(114, person.getId());
    }

    @Test
    void PersonAllAttributes(){
        person = new Person(4594, "Muster", "Hans");
        assertEquals(4594, person.getId());
        assertEquals("Muster", person.getName());
        assertEquals("Hans", person.getSurname());
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Person.class)
                .withOnlyTheseFields("id")
                .verify();
    }

    @Test
    void equalsTrue(){
        person = new Person(4654, "Peter", "Müller");
        Person samePerson = new Person(4654, "Peter", "Müller");
        assertTrue(person.equals(samePerson));
    }

    @Test
    void equalsFalse(){
        person = new Person(5673, "Daniel", "Albisser");
        Person anotherPerson = new Person(8573, "John", "Doe");
        assertFalse(person.equals(anotherPerson));
    }

    @Test
    void equalsWithNull() {
        person = new Person(1234, "Jane", "Doe");
        assertFalse(person.equals(null));
    }

    @Test
    void equalsWithDifferentClass() {
        person = new Person(1234, "Jane", "Doe");
        String other = "Not a Person";
        assertFalse(person.equals(other));
    }

    @Test
    void equalsDifferentAttributes() {
        person = new Person(1234, "John", "Doe");
        Person otherPerson = new Person(1234, "Jane", "Smith");
        assertTrue(person.equals(otherPerson));
    }

    @Test
    void hashCodeSameTrue(){
        person = new Person(3245, "Susan", "Albricht");
        Person samePerson = new Person(3245, "Susan", "Albricht");
        assertEquals(person.hashCode(), samePerson.hashCode());
    }

    @Test
    void hashCodeSameFalse(){
        person = new Person(3245, "Susan", "Albricht");
        Person samePerson = new Person(4756, "Christine", "Sutter");
        assertNotEquals(person.hashCode(), samePerson.hashCode());
    }
}