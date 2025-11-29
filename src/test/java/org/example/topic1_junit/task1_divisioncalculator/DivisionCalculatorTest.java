package org.example.topic1_junit.task1_divisioncalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DivisionCalculatorTest {

    @Test
    void testDivision() {
        Assertions.assertEquals(5, DivisionCalculator.divide(10, 2));
    }

    @Test
    void divideByZero() {
        Assertions.assertThrows(ArithmeticException.class, ()
                -> DivisionCalculator.divide(10, 0));
    }
}