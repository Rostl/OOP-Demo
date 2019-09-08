package by.rost.jd01_18.ex1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneDemo {

    public static void main(String[] args) {
        test2();
    }

    private static void test2() {
        String value = "asdfasdf sdfsdf +375297295542 asdfasdf asdfasdfasdf " +
                "sdfas+375 (29) 159-0896 dfssdfg asdf asdf as dfas80 29 7662933df asdf a sdf";
        Pattern pattern = Pattern.compile("(\\+375|80)(\\s?\\(?(?<code>25|29|33|44)\\)?\\s?(\\d{3})-?\\d{2}-?\\d{2})");
        Matcher matcher = pattern.matcher(value);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
//            String replace = matcher.group().replace(matcher.group(1), "+375");
            String result = "+375" + matcher.group(2);
            matcher.appendReplacement(stringBuffer, "$1$2");
//            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group("code"));
        }
        matcher.appendTail(stringBuffer);

        System.out.println(stringBuffer);
    }

    private static void test() {
        String value = "+375297295542";
        Pattern pattern = Pattern.compile("^(\\+375|80)\\s?\\(?(25|29|33|44)\\)?\\s?(\\d)(\\2)-?\\d{2}-?\\d{2}$");
        Matcher matcher = pattern.matcher(value);
        System.out.println(matcher.matches());
    }

    private  static void test3(){
        String value = "80(29)378-68-96";
        Pattern pattern = Pattern.compile("^(\\+375|8\\s?0)\\s?\\((25|29|33|44)\\)\\s?\\d{3}-\\d{2}-\\d{2}$");
        Matcher matcher = pattern.matcher(value);
        System.out.println(matcher.matches());
    }
}
