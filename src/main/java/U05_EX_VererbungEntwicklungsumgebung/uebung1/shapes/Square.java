package U05_EX_VererbungEntwicklungsumgebung.uebung1.shapes;

public class Square extends Rectangle{

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
