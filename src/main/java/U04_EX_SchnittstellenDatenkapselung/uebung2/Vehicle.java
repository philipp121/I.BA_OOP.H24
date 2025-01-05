package U04_EX_SchnittstellenDatenkapselung.uebung2;

public class Vehicle implements Switchable{
    private boolean vehicle;
    private Motor motor;
    private Light lights;

    @Override
    public void switchOn() {
        if (isSwitchedOff()) {
            motor.switchOn();
            lights.switchOn();
        }
    }

    @Override
    public void switchOff() {
        if(isSwitchedOff()) {
            motor.switchOff();
            lights.switchOff();
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return vehicle;
    }

    @Override
    public boolean isSwitchedOff() {
        return !vehicle;
    }
}
