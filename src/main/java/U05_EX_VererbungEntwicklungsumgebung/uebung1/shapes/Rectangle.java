package U05_EX_VererbungEntwicklungsumgebung.uebung1.shapes;

public class Rectangle extends Shape implements Named{

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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
