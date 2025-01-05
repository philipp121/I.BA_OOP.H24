package U06_EX_PolymorphieUnitTesting.uebung2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMaxWithFirstGreater() {
        // Testfall 1: a > b
        assertEquals(5, Main.max(5, 3), "Max should return 5 when comparing 5 and 3");
    }

    @Test
    void testMaxWithSecondGreater() {
        // Testfall 2: b > a
        assertEquals(4, Main.max(2, 4), "Max should return 4 when comparing 2 and 4");
    }

    @Test
    void testMaxWithEqualValues() {
        // Testfall 3: a == b
        assertEquals(7, Main.max(7, 7), "Max should return 7 when both values are equal");
    }

    @Test
    void testWithError() {
        // Testfall 3: a == b
        assertNotEquals(8, Main.max(7, 7), "Test Error");
    }

}