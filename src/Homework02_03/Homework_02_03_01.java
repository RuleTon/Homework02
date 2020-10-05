package Homework02_03;

import java.util.*;

public class Homework_02_03_01 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "Quake", "Doom", "Wolfenstein", "Rage", "Keen", "Eternal",
                "Rage", "Haretic", "Quake", "Doom"
        );

        Set<String> unique = new HashSet<String>(words);

        System.out.println("Список слов:");
        System.out.println(words.toString());
        System.out.println("Уникальные слова:");
        System.out.println(unique.toString());
        System.out.println("Частота:");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
    }
}
