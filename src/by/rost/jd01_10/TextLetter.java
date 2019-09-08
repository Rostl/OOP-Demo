package by.rost.jd01_10;

import java.util.HashMap;
import java.util.Map;

public class TextLetter {
    public static void main(String[] args) {
        Integer count = 1;
        String myString = "qwerty Qwerty rt oop oop qazwsx OOP Java java ";
        Map<String, Integer> myMapString = new HashMap();
        for (String mapString : myString.split(" ")) {
            if (myMapString.containsKey(mapString)) {
                myMapString.put(mapString, myMapString.get(mapString).intValue() + 1);
            } else {
                myMapString.put(mapString, count);
            }
        }
        System.out.printf("%-10s%-5s%n", "Слово", "Частота встречаемости");
        System.out.println("");
        for (Map.Entry<String, Integer> entry : myMapString.entrySet()) {
            System.out.printf("%-15s%-10s%n", entry.getKey(), entry.getValue());
        }
    }
}