package org.example.topic1_junit.task7_leapyearchecker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LeapYearCheckerTest {

    @Test
    void isLeapYear() {
        Assertions.assertTrue(LeapYearChecker.isLeapYear(2016));
    }

    @Test
    void isNotLeapYear2() {
        Assertions.assertFalse(LeapYearChecker.isLeapYear(1700));
    }

    @Test
    void isLeapYear3() {
        Assertions.assertTrue(LeapYearChecker.isLeapYear(1600));
    }

    @Test
    void isNotLeapYear4() {
        Assertions.assertFalse(LeapYearChecker.isLeapYear(2025));
    }
}