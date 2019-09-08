package by.rost.jd01_5;

public class RomanToArabic {
    public static void main(String[] args) {

        String strUpper = "";
        String str = "CXCViii";
        strUpper = str.toUpperCase();
        int currentValue = 0;
        int nextValue = 0;
        int result = 0;
        for (int i = 0; i < str.length() - 1; i++) {

            currentValue = arabicValueReturner(strUpper.charAt(i));
            nextValue = arabicValueReturner(strUpper.charAt(i + 1));

            if (currentValue < nextValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }
        result += nextValue;
        if (result <= 3999) {
            System.out.println(result);
        } else {
            System.out.println("Выход за границы числа");
        }
    }

    //Возарвщаем значение в зависимсти от римской цифры
    private static int arabicValueReturner(char currentString) {
        switch (currentString) {

            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}


