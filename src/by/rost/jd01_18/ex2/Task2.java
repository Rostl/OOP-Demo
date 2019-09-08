package by.rost.jd01_18.ex2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    public static void main(String[] args) {
        String value = "sdlfjksddf 0xAF kjsdrfkjhdf 0XD asdflkjnfsdg 0x22C";
        String regex = "0[xX][\\da-fA-F]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    private static void test() {
        String value = "dassdf asdf asdf 0XFF asdfgdf 0x1 assdfg " +
                "0x10 0XFFfF";
        String regex = "0[xX]([\\dA-Fa-f]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
