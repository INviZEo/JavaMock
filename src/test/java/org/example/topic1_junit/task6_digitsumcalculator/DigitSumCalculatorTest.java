package org.example.topic1_junit.task6_digitsumcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DigitSumCalculatorTest {
    @Test
    void sumDigits() {
        Assertions.assertEquals(5, DigitSumCalculator.sumDigits(5));
    }

    @Test
    void sumDigitsMultiNum() {
        Assertions.assertEquals(3, DigitSumCalculator.sumDigits(12));
    }

    @Test
    void sumDigitsNegativeNumber() {
        Assertions.assertEquals(10, DigitSumCalculator.sumDigits(-19));
    }

    @Test
    void sumDigitsByZero() {
        Assertions.assertEquals(0, DigitSumCalculator.sumDigits(0));
    }
}