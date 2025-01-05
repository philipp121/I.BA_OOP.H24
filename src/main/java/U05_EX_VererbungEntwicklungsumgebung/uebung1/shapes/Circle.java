package U05_EX_VererbungEntwicklungsumgebung.uebung1.shapes;

public class Circle extends Shape{

    private int diameter;

    public Circle(int x, int y, int diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public int getPerimeter() {
        return (int) Math.round(diameter * Math.PI);
    }

    @Override
    public int getArea() {
        return (int) Math.round(Math.pow((double) diameter / 2, 2) * Math.PI);
    }
}
