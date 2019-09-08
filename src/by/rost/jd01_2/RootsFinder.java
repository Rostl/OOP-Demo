package by.rost.jd01_2;

import java.util.Scanner;

public class RootsFinder {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Введите а");
        double a = sc.nextDouble();
        System.out.println("Введите b");
        double b = sc.nextDouble();
        System.out.println("Введите с");
        double c = sc.nextDouble();

        rootsCalculation(a, b, c);


    }

    public static void rootsCalculation(double a, double b, double c) {
        double qwe = discriminant(a, b ,c);
        if (isPositive(qwe)) {
            System.out.println("Дискримнант меньше нуля...корней нет!!!");
        } else if (isZero(qwe)) {
            double x = -b / (2 * a);
            System.out.println("x = " + x);
        } else {
            double x1 = (-b + Math.sqrt(qwe)) / (2 * a);
            double x2 = (-b - Math.sqrt(qwe)) / (2 * a);
            System.out.println("x1 = " + x1 + " x2 = " + x2);
        }
    }

    public static double discriminant(double a, double b, double c) {

        double dis = b * b - 4 * a * c;
        return dis;
    }

    public static boolean isPositive(double dis) {
        return dis < 0;
    }

    public static boolean isZero(double dis) {
        return dis == 0;
    }
}