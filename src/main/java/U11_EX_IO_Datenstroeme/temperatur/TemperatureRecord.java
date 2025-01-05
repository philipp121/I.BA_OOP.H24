package U11_EX_IO_Datenstroeme.temperatur;

import java.time.LocalDateTime;

public class TemperatureRecord {
    private LocalDateTime timestamp;
    private float temperature;
    private int humidity;

    public TemperatureRecord(LocalDateTime timestamp, float temperature, int humidity) {
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    /**
     * Get the timesampt from the record
     * @return the timestamp from the current record
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Get the temperature from the record
     * @return the temperature correlating to the current record
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * Get the humidity from the record
     * @return the humidity correlating to the current record
     */
    public int getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "TemperatureRecord{" +
                "timestamp=" + timestamp +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}