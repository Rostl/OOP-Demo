package by.rost.jd01_9;

import java.util.ArrayList;

public class ArrListReplace {
    public static void main(String[] args) {
        String replaceString = "****";
        ArrayList<String> strElemetns = new ArrayList<>();
        strElemetns.add("qwer");
        strElemetns.add("Car");
        strElemetns.add("see");
        strElemetns.add("My");
        strElemetns.add("help");
        strElemetns.add("end");

        System.out.println("Исходная коллекция");
        printList(strElemetns);
        valueReplacement(replaceString, strElemetns);
        System.out.println("Новая коллекция");
        printList(strElemetns);
    }

    //Заменить все элементы длинной четыре символа
    private static void valueReplacement(String replaceString, ArrayList<String> strElemetns) {
        for (int i = 0; i < strElemetns.size(); i++) {
            if (strElemetns.get(i).length() == 4) {
                strElemetns.set(i, replaceString);
            }
        }
        System.out.println();
    }

    //Вывод на консоль
    private static <T> void printList(Iterable<T> strElemetns) {
        for (T str : strElemetns) {
            System.out.printf("\"%s\" ", str);
        }
    }
}
