package U07_EX_EqualsHashCodeCompare.uebung2.point;

import java.util.Comparator;

public class PointComparator implements Comparator<Point> {

    // Comparator for sorting by x coordinate
    public static final Comparator<Point> BY_X = Comparator.comparingInt(Point::getX);

    // Comparator for sorting by y coordinate
    public static final Comparator<Point> BY_Y = Comparator.comparingInt(Point::getY);

    // Comparator for sorting by distance from origin
    public static final Comparator<Point> BY_DISTANCE =
            Comparator.comparingDouble(p -> Math.sqrt(p.getX() * p.getX() + p.getY() * p.getY()));

    @Override
    public int compare(Point p1, Point p2) {
        // Default comparison: sorts by x coordinate
        return BY_X.compare(p1, p2);
    }
}