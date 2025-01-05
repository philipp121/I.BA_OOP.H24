package U06_EX_PolymorphieUnitTesting.uebung1.shape;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Rectangle(0, 0, 10, 20);
        Shape shape2 = new Circle(-10, -10, 8);

        shape1.move(5, 5);
        shape2.move(3, 3);

        // Currently always true, just to show how it should be done with dynamic objects
        if (shape2 instanceof Circle){
            int diameter = ((Circle) shape2).getDiameter();
            System.out.println(diameter);
        } else {
            System.out.println("Shape is not a circle");
        }

    }
}
