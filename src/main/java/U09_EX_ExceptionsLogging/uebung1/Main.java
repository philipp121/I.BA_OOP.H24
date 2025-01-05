package U09_EX_ExceptionsLogging.uebung1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            float value = Float.valueOf(input);
        } while (!"exit".equals(input));
        System.out.println("Programm beendet.");
    }
}
