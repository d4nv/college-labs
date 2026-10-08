package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testAddition() {
        assertEquals(7, calc.add(3, 4));
    }

    @Test
    void testSubtraction() {
        assertEquals(2, calc.subtract(5, 3));
    }

    @Test
    void testSubtractionNegative() {
        assertThrows(IllegalStateException.class, () -> calc.subtract(2, 5));
    }

    @Test
    void testMultiplication() {
        assertEquals(20, calc.multiply(4, 5));
    }

    @Test
    void testMultiplicationOverflow() {
        assertThrows(UnsupportedOperationException.class, () -> calc.multiply(Integer.MAX_VALUE, 2));
    }

    @Test
    void testDivision() {
        assertEquals(3, calc.divide(9, 3));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(9, 0));
    }
}
