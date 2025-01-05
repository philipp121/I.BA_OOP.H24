package U05_EX_VererbungEntwicklungsumgebung.uebung1.switchable;

public class Motor implements CountingSwitchable {

    private boolean running;
    private int rpm;
    private int switchCounter;

    public Motor() {
        this.running = false;
        this.rpm = 0;
        switchCounter = 0;
    }

    @Override
    public void switchOn() {
        if (isSwitchedOff()) {
            running = true;
            rpm = 4500;
            switchCounter++;
        }
    }

    @Override
    public void switchOff() {
        if (isSwitchedOn()) {
            running = false;
            rpm = 0;
            switchCounter++;
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return running;
    }

    @Override
    public boolean isSwitchedOff() {
        return !running;
    }

    @Override
    public int getSwitchCount() {
        return 0;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "running=" + isSwitchedOn() +
                ", rpm=" + rpm +
                '}';
    }

}
