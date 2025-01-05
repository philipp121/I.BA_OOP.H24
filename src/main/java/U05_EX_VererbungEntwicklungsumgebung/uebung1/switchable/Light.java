package U05_EX_VererbungEntwicklungsumgebung.uebung1.switchable;

public class Light implements Switchable {
    private boolean light;

    @Override
    public void switchOn() {
        if (isSwitchedOff()) {
            light = true;
        }
    }

    @Override
    public void switchOff() {
        if(isSwitchedOn()) {
            light = false;
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return light;
    }

    @Override
    public boolean isSwitchedOff() {
        return !light;
    }
}
