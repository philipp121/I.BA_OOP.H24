package U04_EX_SchnittstellenDatenkapselung.uebung2;

public class Motor implements Switchable{

    private boolean running;
    private int rpm;

    public Motor() {
        this.running = false;
        this.rpm = 0;
    }

    @Override
    public void switchOn() {
        if (isSwitchedOff()) {
            running = true;
            rpm = 4500;
        }
    }

    @Override
    public void switchOff() {
        if (isSwitchedOn()) {
            running = false;
            rpm = 0;
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
    public String toString() {
        return "Motor{" +
                "running=" + isSwitchedOn() +
                ", rpm=" + rpm +
                '}';
    }
}
