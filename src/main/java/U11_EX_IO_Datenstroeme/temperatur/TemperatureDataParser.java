package U11_EX_IO_Datenstroeme.temperatur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TemperatureDataParser {

    private String resourceFileName;

    public TemperatureDataParser(String resourceFileName) {
        this.resourceFileName = resourceFileName;
    }

    /**
     * Parse fields and create temperature record
     * @return populated temperature record list
     */
    public List<TemperatureRecord> parse() {
        List<TemperatureRecord> records = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\"");

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                getClass().getClassLoader().getResourceAsStream(
                                        resourceFileName), "UTF-8")
                ))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");

                LocalDateTime timestamp = LocalDateTime.parse(fields[1], formatter);
                float temperature = Float.parseFloat(fields[2]);
                int humidity = Integer.parseInt(fields[3]);

                records.add(new TemperatureRecord(timestamp, temperature, humidity));
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

        return records;
    }
}
