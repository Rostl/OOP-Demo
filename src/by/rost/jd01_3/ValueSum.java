package by.rost.jd01_3;

import java.util.Scanner;

public class ValueSum {
    public static void main(String [] args) {

        int sum = 0;
        int rem = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число!");
        int a = sc.nextInt();
        sumRem(a, sum, rem);


    }

    public static void sumRem(int a, int sum, int rem) {
        while (a != 0) {
            rem = a % 10;
            sum += rem;
            a /= 10;
        }
        System.out.println("Сумма цифр числа ровна - " + sum);

    }

}
