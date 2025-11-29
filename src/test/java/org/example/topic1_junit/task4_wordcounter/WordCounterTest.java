package org.example.topic1_junit.task4_wordcounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordCounterTest {

    @Test
    void testEmptyString() {
        String word = "";
        Assertions.assertEquals(1, WordCounter.countWords(word));
    }

    @Test
    void testThreeWords() {
        String word = "word в ф";
        Assertions.assertEquals(3, WordCounter.countWords(word));
    }

    @Test
    void testOneWord() {
        String word = "word";
        Assertions.assertEquals(1, WordCounter.countWords(word));
    }

    @Test
    void testWithTab() {
        String word = "word of      tree" +
                "doesnt mean anything";
        Assertions.assertFalse(5 == WordCounter.countWords(word));
    }
}