package org.example.topic1_junit.task4_wordcounter;

public class WordCounter {

    public static int countWords(String text) { // Здесь долежн быть StringBuilder
        return text.split(" ").length; /* trim().split("\\s+").length можно добавить чтобы были
            обработаны любые количества пробелов или табуляция сохраняя логику от слова до слова */
    }
}