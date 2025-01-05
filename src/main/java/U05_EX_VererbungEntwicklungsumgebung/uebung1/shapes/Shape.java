package U05_EX_VererbungEntwicklungsumgebung.uebung1.shapes;

public abstract class Shape {
    private int x,y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int newX, int newY){
        this.x = newX;
        this.y =newY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract int getPerimeter();

    public abstract int getArea();
}
