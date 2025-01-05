package U04_EX_SchnittstellenDatenkapselung.uebung2;

public class Main {
    public static void main(String[] args) {
        Motor motor = new Motor();
        System.out.println(motor);
        motor.switchOn();
        System.out.println(motor);
        motor.switchOff();
        System.out.println(motor);
    }
}
