package U03_EX_Kontrollstrukturen.uebung2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Version 1");
        countToTen();
        System.out.println("Version 2");
        countToTen2();
        System.out.println("Version 3");
        countToTen3();
        System.out.println("Float While");
        floatWhile();
        System.out.println("Float For");
        floatFor();

        printBox(10,4);
        System.out.println("----------------------------------");

        printBox2(12,7);
    }

    public static void countToTen(){
        for (int i = 0; i < 11; i++){
            System.out.println(i);
        }
    }

    public static void countToTen2(){
        int i = 0;
        while (i < 11){
            System.out.println(i);
            i++;
        }
    }

    public static void countToTen3(){
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i<11);
    }

    public static void floatWhile(){
        float a = 0.9f;
        int iterations = 0;
        while (a <= 1.0f) {
            System.out.println(a);
            a += 0.000025f;
            iterations++;
        }
        System.out.println("Iterations: " + iterations);
    }

    public static void floatFor(){
        float a = 0.9f;
        int iterations = 0;
        for (float i = 0; i < 4000; i++){
            System.out.println(a);
            a += 0.000025f;
            iterations++;
        }
        System.out.println("Iterations: " + iterations);
    }

    public static void printBox(final int width, final int height){
        printFullLine(width);
        for (int i = 0; i < height; i++){
            printLine(width);
        }
        printFullLine(width);
    }

    private static void printFullLine(final int width){
        for (int i = 0; i < width; i++){
            System.out.print('#');
        }
        System.out.println();
    }

    private static void printLine(final int width){
        System.out.print('#');
        for (int i = 0; i < width -2; i++){
            System.out.print(' ');
        }
        System.out.print('#');
        System.out.println();
    }

    public static void printBox2(final int width, final int height){
        for (int i = 1; i <= height; i++){
            for (int j = 1; j <= width; j++){
                if (i == 1 || i == height || j == 1 || j == width){
                    System.out.print('#');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}