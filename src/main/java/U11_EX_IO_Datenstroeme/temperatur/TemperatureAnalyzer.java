package U11_EX_IO_Datenstroeme.temperatur;

import java.util.List;

public class TemperatureAnalyzer {

    /**
     * Finds the highest temperature in a Record set
     * @param records the temperature record set
     * @return the highest found temperature record or null
     */
    public static TemperatureRecord findHighestTemperature(List<TemperatureRecord> records) {
        return records.stream()
                .max((r1, r2) -> Float.compare(r1.getTemperature(), r2.getTemperature()))
                .orElse(null);
    }

    /**
     * Finds the lowest temperature in a record set
     * @param records the temperature record set
     * @return the lowest found temperature record or null
     */
    public static TemperatureRecord findLowestTemperature(List<TemperatureRecord> records) {
        return records.stream()
                .min((r1, r2) -> Float.compare(r1.getTemperature(), r2.getTemperature()))
                .orElse(null);
    }

    /**
     * Calculates the average temperature in a temperature set
     * @param records the temperature set
     * @return the average temperature from the temperature set
     */
    public static double calculateAverageTemperature(List<TemperatureRecord> records) {
        return records.stream()
                .mapToDouble(TemperatureRecord::getTemperature)
                .average()
                .orElse(0.0);
    }
}
