package U06_EX_PolymorphieUnitTesting.uebung3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    protected SimpleCalculator sc;

    @BeforeEach
    void setUp() {
        sc = new SimpleCalculator();
    }

    @Test
    void additionWithNegativeNumbers() {
        assertEquals(-30, sc.addition(-27, -3));
    }

    @Test
    void additionWithPositiveNumbers() {
        assertEquals(368, sc.addition(308, 60));
    }

    @Test
    void additionWithMixedSigns() {
        assertEquals(-104, sc.addition(-120, 16));
        assertEquals(265, sc.addition(280, -15));
    }

    @Test
    void additionWithZero() {
        assertEquals(0, sc.addition(0, 0));
        assertEquals(5, sc.addition(5, 0));
        assertEquals(-5, sc.addition(-5, 0));
    }

    @Test
    void additionLow() {
        int result = sc.addition(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(0, result, "Expected wrap-around behavior for Integer.MIN_VALUE addition.");
    }

    @Test
    void additionHigh() {
        int result = sc.addition(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(-2, result, "Expected wrap-around behavior for Integer.MIN_VALUE addition.");
    }

    @Test
    void additionBoundary() {
        assertEquals(Integer.MAX_VALUE - 1, sc.addition(Integer.MAX_VALUE - 2, 1));
        assertEquals(Integer.MIN_VALUE + 1, sc.addition(Integer.MIN_VALUE + 2, -1));
    }

    @Test
    void additionOverflow() {
        assertEquals(Integer.MIN_VALUE, sc.addition(Integer.MAX_VALUE, 1));
        assertEquals(Integer.MAX_VALUE, sc.addition(Integer.MIN_VALUE, -1));
    }

    @Test
    void additionFailureScenario() {
        // Deliberately assert a wrong result to see if test catches it
        assertNotEquals(100, sc.addition(50, 40), "Addition result is incorrect.");
    }
}