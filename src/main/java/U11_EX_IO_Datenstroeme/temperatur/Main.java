package U11_EX_IO_Datenstroeme.temperatur;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String resourceFileName = "netatmo-export.csv";

        // Parse the CSV file from resources
        TemperatureDataParser parser = new TemperatureDataParser(resourceFileName);
        List<TemperatureRecord> records = parser.parse();

        // Analyze the data
        TemperatureRecord highest = TemperatureAnalyzer.findHighestTemperature(records);
        TemperatureRecord lowest = TemperatureAnalyzer.findLowestTemperature(records);
        double average = TemperatureAnalyzer.calculateAverageTemperature(records);

        // Display results
        System.out.println("Highest Temperature: " + highest);
        System.out.println("Lowest Temperature: " + lowest);
        System.out.println("Average Temperature: " + average);
    }
}
