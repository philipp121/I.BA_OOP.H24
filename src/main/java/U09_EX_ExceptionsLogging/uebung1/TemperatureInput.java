package U09_EX_ExceptionsLogging.uebung1;

import java.util.Scanner;

public class TemperatureInput {

    public static void main(String[] args) {
        TemperatureInput ti = new TemperatureInput();
        ti.run();
    }

    public void run() {
        String input;
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            try {
                Temperature temperature = new Temperature(Double.valueOf(input));
            } catch (IllegalArgumentException e){
                if ("exit".equals(input)){
                    run = false;
                } else if (e instanceof NumberFormatException){
                    System.out.println("Input needs to be a number!");
                }
            }

        } while (run);
        System.out.println("Programm beendet.");
    }
}
