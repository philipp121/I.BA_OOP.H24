package U07_EX_EqualsHashCodeCompare.uebung2.person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(345, "Müller", "Hans"));
        persons.add(new Person( 3, "Küttel", "Sabine"));
        persons.add(new Person(3045, "Doe", "John"));
        persons.add(new Person( 120, "Doe", "Alfred"));

        System.out.println("----Unsorted----");
        for (Person person : persons){
            System.out.println(person);
        }

        Collections.sort(persons);

        System.out.println("----Sorted----");
        for (Person person : persons){
            System.out.println(person);
        }

        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(345, "Müller", "Hans" ));
        persons2.add(new Person( 3, "Küttel", "Sabine"));
        persons2.add(new Person(3045, "Doe", "Jane"));
        persons2.add(new Person( 120, "Doe", "Alfred"));

        System.out.println("----Unsorted----");
        for (Person person : persons2){
            System.out.println(person);
        }

        persons2.sort(PersonComparator.BY_NAME_THEN_SURNAME);
        System.out.println("----Sorted by Name then Surname----");
        for (Person person : persons2){
            System.out.println(person);
        }

    }
}
