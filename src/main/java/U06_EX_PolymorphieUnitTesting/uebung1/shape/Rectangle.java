package U06_EX_PolymorphieUnitTesting.uebung1.shape;

public class Rectangle extends Shape {

    private int width, height;
    private String name;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.name = "Rectangle";
    }

    public void changeDimension(int newWidth, int newHeight){
        this.width = newWidth;
        this.height = newHeight;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getPerimeter() {
        return (2 * this.width) + (2 * this.height);
    }

    @Override
    public int getArea() {
        return width * height;
    }
}
