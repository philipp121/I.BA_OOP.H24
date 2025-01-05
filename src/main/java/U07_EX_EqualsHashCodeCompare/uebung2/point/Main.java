package U07_EX_EqualsHashCodeCompare.uebung2.point;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Point> points = new ArrayList<>();
        points.add(new Point(10, 5));
        points.add(new Point(43, 8));
        points.add(new Point(-7, -4));
        points.add(new Point(410, -5));

        System.out.println("----Unsorted----");
        for (Point point : points) {
            System.out.println(point);
        }

        points.sort(PointComparator.BY_Y);

        System.out.println("----Sorted by Y----");
        for (Point point : points) {
            System.out.println(point);
        }

        points.sort(PointComparator.BY_X);

        System.out.println("----Sorted by X----");
        for (Point point : points) {
            System.out.println(point);
        }

        points.sort(PointComparator.BY_DISTANCE);

        System.out.println("----Sorted by Distance to Origin----");
        for (Point point : points) {
            System.out.println(point);
        }
    }
}
