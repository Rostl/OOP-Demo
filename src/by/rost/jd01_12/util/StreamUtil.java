package by.rost.jd01_12.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;

public class StreamUtil {
    private StreamUtil() {
    }

    /*
     * Считывает файл, записывает символы стихотворения в HashMap, подсчитывает количество повторений символов
     * */
    public static Map<Character, Integer> readAndCalculateLetter(Map<Character, Integer> textLetters, Path textPath) throws FileNotFoundException {
        Character oneLetter;
        try (Scanner scanText = new Scanner(new BufferedInputStream(new FileInputStream(textPath.toFile()))).useDelimiter(",|\\.|;|\\?|:|!|\\s")) {
            String oneWord;
            while (scanText.hasNext()) {
                oneWord = scanText.next().toLowerCase();
                for (int i = 0; i < oneWord.length(); i++) {
                    oneLetter = oneWord.charAt(i);
                    if (textLetters.get(oneLetter) != null) {
                        textLetters.put(oneLetter, textLetters.get(oneLetter) + 1);
                    } else {
                        textLetters.put(oneLetter, 1);
                    }
                }
            }
        }
        return textLetters;
    }

    /*
     * Выводит на консоль символы и количество их повторений в тексте
     * */
    public static void printMapOfLetters(Map<Character, Integer> textLetters) {
        for (Map.Entry<Character, Integer> entry : textLetters.entrySet()) {
            System.out.printf("%-2s%-4s%-1s%n", entry.getKey(), "-->", entry.getValue());
        }
    }
}