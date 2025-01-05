package U07_EX_EqualsHashCodeCompare.uebung2.point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PointComparatorTest {

    private List<Point> points;

    @BeforeEach
    void setUp() {
        points = new ArrayList<>();
        points.add(new Point(3, 4));  // Distance = 5
        points.add(new Point(1, 1));  // Distance = 1.41
        points.add(new Point(0, 0));  // Distance = 0
        points.add(new Point(6, 8));  // Distance = 10
    }

    @Test
    void testSortByX() {
        Collections.sort(points, PointComparator.BY_X);

        List<Point> expected = List.of(
                new Point(0, 0),
                new Point(1, 1),
                new Point(3, 4),
                new Point(6, 8)
        );

        assertEquals(expected, points);
    }

    @Test
    void testSortByY() {
        Collections.sort(points, PointComparator.BY_Y);

        List<Point> expected = List.of(
                new Point(0, 0),
                new Point(1, 1),
                new Point(3, 4),
                new Point(6, 8)
        );

        assertEquals(expected, points);
    }

    @Test
    void testSortByDistance() {
        Collections.sort(points, PointComparator.BY_DISTANCE);

        List<Point> expected = List.of(
                new Point(0, 0),
                new Point(1, 1),
                new Point(3, 4),
                new Point(6, 8)
        );

        assertEquals(expected, points);
    }

    @Test
    void testCustomComparatorDefaultCompareByX() {
        // Use the default PointComparator (BY_X)
        Collections.sort(points, new PointComparator());

        List<Point> expected = List.of(
                new Point(0, 0),
                new Point(1, 1),
                new Point(3, 4),
                new Point(6, 8)
        );

        assertEquals(expected, points);
    }
}