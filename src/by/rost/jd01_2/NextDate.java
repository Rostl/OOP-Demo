package by.rost.jd01_2;

import java.util.Scanner;

public class NextDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите день:");
        int day = scanner.nextInt();

        System.out.println("Введите месяц:");
        int month = scanner.nextInt();

        System.out.println("Введите год:");
        int year = scanner.nextInt();

        if (isDateValid(day, month, year)) {


            nextDay(day, month, year);
        } else {
            System.out.println("Дата введена некорректно!");
        }
    }

    public static boolean isDateValid(int day, int month, int year) {
        if (day <= 0 || day > 31) {
            return false;
        }
        if (month <= 0 || month > 12) {
            return false;
        }
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                if (day == 31) {
                    return false;
                }
                break;
            case 2:
                if (isTemporal(year)) {
                    if (day > 29) {
                        return false;
                    }
                } else {
                    if (day > 28) {
                        return false;
                    }
                }
                break;
        }

        return true;
    }

    public static void nextDay(int day, int month, int year) {

        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                if (day == 30) {
                    day = 1;
                    month += 1;
                } else {
                    day += 1;
                }
                break;
            case 2:
                if (isTemporal(year)) {
                    if (day == 29) {
                        day = 1;
                        month += 1;
                    } else {
                        day += 1;
                    }
                } else {
                    if (day == 28) {
                        day = 1;
                        month += 1;
                    } else {
                        day += 1;
                    }
                }
                break;
            case 12:
                if (day == 31) {
                    day = 1;
                    month = 1;
                    year += 1;
                }
                break;
            default:
                if (day == 31) {
                    day = 1;
                    month += 1;
                } else {
                    day += 1;
                }

        }
        printNextDay(day, month, year);

    }

    public static void printNextDay(int day, int month, int year) {
        System.out.println(day + "." + month + "." + year);
    }

    public static boolean isTemporal(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}