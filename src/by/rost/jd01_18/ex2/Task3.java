package by.rost.jd01_18.ex2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    public static void main(String[] args) {
        String value = "asdf<p>asdfasdfsdf aasdf </p> sdasdf " +
                "<p id=\"25\">fd gdfgh gh</p> fdsf </br>sas df " +
                "<p class='sdsdf' id='222'>tesx tedsg </p>sdf <p id='67567'> asdasdf";
        String regex = "(<p.*?>)(.*?</p>)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "<p>$2");
        }
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer);
    }
}
