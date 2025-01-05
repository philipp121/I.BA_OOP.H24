package U03_EX_Kontrollstrukturen.uebung1;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        System.out.println(max(a, b));
    }

    /**
     * returns the bigger value of two numbers. uses Ternary Operator condition ? value_if_true : value_if_false;
     * @param a a number
     * @param b another number
     * @return the bigger value of the two numbers
     */
    public static int max(int a, int b){
        return (a > b) ? a : b;
    }

    public static int max(int a, int b, int c){
        if (a > b && a > c){
            return a;
        }else if (b > c){
            return b;
        }else {
            return c;
        }
    }

    public static int max1(int a, int b, int c){
        return max(max(a, b), c);
    }

    /**
     * returns the smaller value of two numbers. Ternary Operator condition ? value_if_true : value_if_false;
     * @param a a number
     * @param b another number
     * @return the smaller value of the two numbers
     */
    public static int min (int a, int b){
        return (a < b) ? a : b;
    }
}
