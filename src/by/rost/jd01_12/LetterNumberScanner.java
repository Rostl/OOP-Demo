package by.rost.jd01_12;

import by.rost.jd01_12.util.StreamUtil;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class LetterNumberScanner {
    public static void main(String[] args) {
        Path textPath = Paths.get("resources", "temp", "test.txt");
        Map<Character, Integer> textLetters = new HashMap();
        try {
            StreamUtil.readAndCalculateLetter(textLetters, textPath);
            StreamUtil.printMapOfLetters(textLetters);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}