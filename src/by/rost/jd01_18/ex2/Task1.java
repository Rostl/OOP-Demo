package by.rost.jd01_18.ex2;

import java.util.regex.Pattern;

public class Task1 {

    public static void main(String[] args) {
        String value = "box_box99@gmail99_mail.ru.com".toLowerCase();
        String regex = "^[a-z]\\w*@(\\w|\\.)+\\.(org|com)$";
        boolean result = Pattern.matches(regex, value);
        System.out.println(result);
    }
}
