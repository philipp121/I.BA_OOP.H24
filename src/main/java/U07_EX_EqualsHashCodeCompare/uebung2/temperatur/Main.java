package U07_EX_EqualsHashCodeCompare.uebung2.temperatur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Temperature> temperatures = new ArrayList<>();
        temperatures.add(new Temperature(20));
        temperatures.add(new Temperature(-3));
        temperatures.add(new Temperature(-10));
        temperatures.add(new Temperature(33));

        System.out.println("----Unsorted----");
        for (Temperature temperature : temperatures){
            System.out.println(temperature);
        }

        Collections.sort(temperatures);

        System.out.println("----Sorted----");
        for (Temperature temperature : temperatures){
            System.out.println(temperature);
        }


    }
}
