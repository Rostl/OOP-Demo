package by.rost.jd01_5;

import java.util.Scanner;

public class reversString {

    public static void main(String[] args) {

        Scanner scanWord = new Scanner(System.in);
        System.out.println("Введите слово");
        String currentWord = scanWord.nextLine();
        System.out.print("Введеная строка - ");
        System.out.println(currentWord);
        System.out.print("Перевернутая строка - ");
        System.out.println(reversStringBuilder(currentWord));


        if (strEquals(reversStringBuilder(currentWord), currentWord)){
            System.out.println("Введеное слово - палиндром!");
        }else {
            System.out.println("К сожалению слово не является палиндромом!");
        }

    }
    //Сравниваем 2 строки
    public static boolean strEquals(String currentString, String reversString){
        return currentString.equals(reversString);
    }
        //Переворачиваем строку
    private static String reversStringBuilder(String currentWord) {
        StringBuilder reversBuilder = new StringBuilder(currentWord);
        String reversWord = (reversBuilder.reverse()).toString();
        return reversWord;
    }

}
