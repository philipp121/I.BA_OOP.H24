package U06_EX_PolymorphieUnitTesting.uebung1.point;

public class Point {
    private int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point){
        this.x = point.getX();
        this.y = point.getY();
    }

    public void moveRelative(int x, int y){
        this.x += x;
        this.y += y;
    }

    public void moveRelative(Point point){
        this.x += point.getX();
        this.y += point.getY();
    }

    public void moveRelative(double angle, int r){
        this.x += (int) (r * Math.round(Math.cos(angle)));
        this.y += (int) (r * Math.round(Math.sin(angle)));
    }

    public void moveByPolarCoordinates(double angle, int r){
        this.x += (int) (r * Math.round(Math.cos(angle)));
        this.y += (int) (r * Math.round(Math.sin(angle)));
    }

    public void moveByPolarCoordinates(){

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
