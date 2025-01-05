package U03_EX_Kontrollstrukturen.uebung1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void max() {
        assertEquals(10, Main.max(10,5));
        assertEquals(-5, Main.max(-10,-5));
        assertEquals(0, Main.max(0,-5));
        assertEquals(10, Main.max(10,10));
    }

    @Test
    void testMax() {
        assertEquals(10, Main.max(10,8, 5));
        assertEquals(10, Main.max(10,4, 9));
        assertEquals(0, Main.max(0,-5, -1));

        assertEquals(-5, Main.max(-10,-5, -14));
        assertEquals(8, Main.max(-2,8, 6));
        assertEquals(0, Main.max(-200,0, -7));

        assertEquals(11, Main.max(4,-6, 11));
        assertEquals(104, Main.max(15,67, 104));
        assertEquals(0, Main.max(-25,-46, 0));

        assertEquals(10, Main.max(10,10, 10));
        assertEquals(0, Main.max(0,0, 0));
        assertEquals(-67, Main.max(-67,-67, -67));
    }

    @Test
    void max1() {
        assertEquals(10, Main.max1(10,8, 5));
        assertEquals(10, Main.max1(10,4, 9));
        assertEquals(0, Main.max1(0,-5, -1));

        assertEquals(-5, Main.max1(-10,-5, -14));
        assertEquals(8, Main.max1(-2,8, 6));
        assertEquals(0, Main.max1(-200,0, -7));

        assertEquals(11, Main.max1(4,-6, 11));
        assertEquals(104, Main.max1(15,67, 104));
        assertEquals(0, Main.max1(-25,-46, 0));

        assertEquals(10, Main.max1(10,10, 10));
        assertEquals(0, Main.max1(0,0, 0));
        assertEquals(-67, Main.max1(-67,-67, -67));

        assertEquals(10, Main.max1(10, 10, 5));
        assertEquals(10, Main.max1(5, 10, 10));
        assertEquals(0, Main.max1(-1, 0, -1));

        assertEquals(Integer.MAX_VALUE, Main.max1(Integer.MAX_VALUE, 100, 200));
    }

    @Test
    void min() {
        assertEquals(5, Main.min(10,5));
        assertEquals(-10, Main.min(-10,-5));
        assertEquals(-5, Main.min(0,-5));
        assertEquals(0, Main.min(0,5));
        assertEquals(10, Main.min(10,10));
        assertEquals(-100, Main.max1(Integer.MIN_VALUE, -100, -200));
    }
}