package U02_EX_KlassenDatentypen.uebung1;

public class Temperature_Complicated {

    private double celsius, kelvin, fahrenheit;

    public Temperature_Complicated() {}

    public Temperature_Complicated(double celsius, double kelvin, double fahrenheit) {
        this.celsius = celsius;
        this.kelvin = kelvin;
        this.fahrenheit = fahrenheit;
    }

    /**
     * Need to be able to work with Ranges of 0°K to 500°K
     * Result needs to be rounded because of floating-point issues. * 100 to get full numbers, round it
     * and then / 100 to get the result again
     */

    public double celsiusToKelvin(double celsius){
        return Math.round((celsius + 273.15) * 100.0) / 100.0;
    }

    public double kelvinToCelsius(double kelvin){
        return Math.round((kelvin - 273.15) * 100.0) / 100.0;
    }

    public double celsiusToFahrenheit(double celsius){
        return Math.round((celsius * 1.8 + 32.0) * 100.0) / 100.0;
    }

    public double fahrenheitToCelsius(double fahrenheit){
        return Math.round(((fahrenheit - 32.0) / 1.8) * 100.0) / 100.0;
    }

    public double kelvinToFahrenheit(double kelvin){
        return celsiusToFahrenheit(kelvinToCelsius(kelvin));
    }

    public double fahrenheitToKelvin(double fahrenheit){
        return celsiusToKelvin(fahrenheitToCelsius(fahrenheit));
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double getKelvin() {
        return kelvin;
    }

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }
}
