package U06_EX_PolymorphieUnitTesting.uebung1.shape;

public class Square extends Rectangle {

    private int size;

    public Square(int x, int y, int size) {
        super(x, y, size, size);
        this.size = size;
    }

    @Override
    public int getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public int getArea() {
        return super.getArea();
    }
}
