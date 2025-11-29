package org.example.topic1_junit.task2_maxfinder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxFinderTest {
    @Test
    void arrayNegativeNumbers() {
        int[] array = {-1, -2, -3};
        Assertions.assertEquals(-1, MaxFinder.findMax(array));
    }

    @Test
    void arraySameNumbers() {
        int[] array = {2, 2, 2};
        Assertions.assertEquals(2, MaxFinder.findMax(array));
    }

    @Test
    void arrayOneNumber() {
        int[] array = {1};
        Assertions.assertDoesNotThrow(() -> MaxFinder.findMax(array));
        Assertions.assertEquals(1, MaxFinder.findMax(array));
    }

    @Test
    void emptyArray() {
        int[] array = {};
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> MaxFinder.findMax(array));
    }
}