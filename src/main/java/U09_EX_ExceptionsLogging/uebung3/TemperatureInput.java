package U09_EX_ExceptionsLogging.uebung3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class TemperatureInput {

    private static final Logger LOG = LoggerFactory.getLogger(TemperatureInput.class);

    public static void main(String[] args) {
        TemperatureInput ti = new TemperatureInput();
        ti.run();
    }

    public void run() {
        String input;
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        do {
            LOG.info("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            try {
                Temperature temperature = new Temperature(Double.valueOf(input));
                LOG.info(temperature.toString());
            } catch (IllegalArgumentException e){
                if ("exit".equals(input)){
                    run = false;
                } else if (e instanceof NumberFormatException){
                    LOG.error("Input needs to be a number!");
                }
            }

        } while (run);
        LOG.info("Programm beendet.");
    }
}
