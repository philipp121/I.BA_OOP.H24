package U07_EX_EqualsHashCodeCompare.uebung2.point;

import java.util.Objects;

public final class Point {
    private final int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point){
        this.x = point.getX();
        this.y = point.getY();
    }

    public Point moveRelative(int x, int y){
        return new Point(this.x + x, this.y + y);
    }

    public Point moveRelative(Point point){
        return new Point(this.x + point.getX(), this.y + point.getY());
    }

    public Point moveRelative(double angle, int r){
        int dx = (int) (r * Math.round(Math.cos(angle)));
        int dy = (int) (r * Math.round(Math.sin(angle)));
        return new Point(this.x + dx, this.y + dy);
    }

    public Point moveByPolarCoordinates(double angle, int r){
        int dx = (int) (r * Math.round(Math.cos(angle)));
        int dy = (int) (r * Math.round(Math.sin(angle)));
        return new Point(this.x + dx, this.y + dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

// Prime Based Hash Implementation
//    @Override
//    public int hashCode() {
//        int result = 17;  // Start with a non-zero prime number
//        result = 31 * result + x;  // Multiply by a prime and add x
//        result = 31 * result + y;  // Multiply by a prime and add y
//        return result;
//    }


    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
