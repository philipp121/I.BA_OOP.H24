package U08_EX_CollectionsEnumsStatic.temperatur.temperature;

public class Main {
    public static void main(String[] args) {
        TemperatureHistory th = new TemperatureHistory();
        th.addTemperature(new Temperature(20));
        th.addTemperature(new Temperature(-5));
        th.addTemperature(new Temperature(33));
        th.addTemperature(new Temperature(4));
        System.out.println(th);
        System.out.println(th.toFormattedString());
    }
}
