package org.example.topic1_junit.task5_palindromechecker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromeCheckerTest {

    @Test
    void isPalindrome() {
        Assertions.assertTrue(PalindromeChecker.isPalindrome("madam"));
    }

    @Test
    void isPalindromeWithUpperCase() {
        Assertions.assertTrue(PalindromeChecker.isPalindrome("madaM"));
    }

    @Test
    void isPalindromeWithSpace() {
        Assertions.assertTrue(PalindromeChecker.isPalindrome("madam madam"));
    }

    @Test
    void isPalindromeEmptyText() {
        Assertions.assertTrue(PalindromeChecker.isPalindrome(""));
    }
}