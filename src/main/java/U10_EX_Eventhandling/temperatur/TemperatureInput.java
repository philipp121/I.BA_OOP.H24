package U10_EX_Eventhandling.temperatur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeListener;
import java.util.Scanner;

public class TemperatureInput implements Runnable{

    private static final Logger LOG = LoggerFactory.getLogger(TemperatureInput.class);

    private boolean run = true;
    private TemperatureHistory temperatureHistory;

    @Override
    public void run() {
        String input;
        Scanner scanner = new Scanner(System.in);
        temperatureHistory = new TemperatureHistory();
        // Create a simple listener
        TemperatureEventListener listener = evt -> {
            switch (evt.getType()){
                case TemperatureEventType.MINIMUM:
                    LOG.info("New Minimum detected: {}", evt.getTemperature());
                    break;
                case TemperatureEventType.MAXIMUM:
                    LOG.info("New Maximum detected: {}", evt.getTemperature());
                    System.out.println("Debug Maximum");
                    break;
            }
        };


        try {
            LOG.info("Adding listener...");
            temperatureHistory.addTemperatureEventListener(listener);
        } catch (IllegalArgumentException e) {
            LOG.error("Error adding listener: {}", e.getMessage());
        }

        do {
            LOG.info("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            try {
                Temperature temperature = new Temperature(Double.parseDouble(input));
                temperatureHistory.addTemperature(temperature);
            } catch (IllegalArgumentException e){
                if ("exit".equalsIgnoreCase(input)){
                    exit();
                } else if (e instanceof NumberFormatException){
                    LOG.error("Input needs to be a number!");
                }
            }

        } while (run);

    }

    private void exit(){
        this.run = false;
        LOG.info(temperatureHistory.toFormattedString());
        LOG.info("Programm beendet.");
    }
}
