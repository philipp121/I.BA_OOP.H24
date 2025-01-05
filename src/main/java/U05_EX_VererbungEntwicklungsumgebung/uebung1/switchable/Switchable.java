package U05_EX_VererbungEntwicklungsumgebung.uebung1.switchable;

public interface Switchable {
    /**
     * Switch the Device on
     */
    void switchOn();

    /**
     * Turn off the Device
     */
    void switchOff();

    /**
     * Check if the Device is switched on
     * @return true if on, false if off
     */
    boolean isSwitchedOn();

    /**
     * Check if the Device is switched off
     * @return true if off, false if on
     */
    boolean isSwitchedOff();
}
