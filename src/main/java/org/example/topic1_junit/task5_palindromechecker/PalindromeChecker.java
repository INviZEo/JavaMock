package org.example.topic1_junit.task5_palindromechecker;

public class PalindromeChecker {
    public static boolean isPalindrome(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed); //здесь нужно заменить на equalsIgnoreCase
    }
}