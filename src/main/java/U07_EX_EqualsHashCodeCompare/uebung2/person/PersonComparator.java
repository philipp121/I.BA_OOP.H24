package U07_EX_EqualsHashCodeCompare.uebung2.person;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    public static final Comparator<Person> BY_NAME_THEN_SURNAME = Comparator.comparing(Person::getName)
            .thenComparing(Person::getSurname);

    @Override
    public int compare(Person p1, Person p2) {
        return BY_NAME_THEN_SURNAME.compare(p1, p2);
    }

    @Override
    public Comparator<Person> reversed() {
        return Comparator.super.reversed();
    }
}
