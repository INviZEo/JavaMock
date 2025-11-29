package org.example.topic1_junit.task6_digitsumcalculator;

public class DigitSumCalculator {
    public static int sumDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int sum = 0;
        for (char digit : numStr.toCharArray()) {
            sum += digit - '0';
        }
        return sum;
    }
}