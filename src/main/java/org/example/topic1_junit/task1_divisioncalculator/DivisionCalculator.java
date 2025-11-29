package org.example.topic1_junit.task1_divisioncalculator;

public class DivisionCalculator {
    public static double divide(int a, int b) {
        return a / b; /* так как в задании указано найти баг и ПРЕДЛОЖИТЬ а не исправить
                       баг будет в том что тут инты и при делении могут быть не целые числа
                       и нужно именить тип на double или float чтобы не затирались числа*/
    }
}
