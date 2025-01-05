package U02_EX_KlassenDatentypen.uebung2;

public class Main {
    public static void main(String[] args) {

        // https://0.30000000000000004.com/

        double test1 = 0.1;
        double test2 = 0.2;
        System.out.println(test1 + test2);

        float test3 = 0.1f;
        float test4 = 0.2f;
        System.out.println(test3 + test4);

        System.out.println(.1 + .2);
        System.out.println(.1f + .2f);

        // int range of values -2147483648...2147483647
        // max int number, when 1 added it start again at -2147483648
        int a = 2147483647;
        System.out.println(a);
        int b = a +1;
        System.out.println(b);

        // float range of values Approximately -3.4028235e+38 to 3.4028235e+38
        float c = 3.4028235e38f;
        System.out.println(c);
        float d = c + 1e38f;
        System.out.println(d);

        int e = 2;
        int f = 5;
        float g = e + (float) f / e;
        System.out.println(g);

    }
}
