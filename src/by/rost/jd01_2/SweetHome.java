package by.rost.jd01_2;

import java.util.Scanner;

public class SweetHome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите сторону a");
        int a = sc.nextInt();
        System.out.println("Введите сторону b");
        int b = sc.nextInt();
        System.out.println("Введите сторону с");
        int c = sc.nextInt();
        System.out.println("Введите сторону d");
        int d = sc.nextInt();
        System.out.println("Введите сторону e");
        int e = sc.nextInt();
        System.out.println("Введите сторону f");
        int f = sc.nextInt();
        homeOnTheLand(a, b, c, d, e, f);

    }

    public static void homeOnTheLand(int a, int b, int c, int d, int e, int f) {
        if ((a <= e && b <= f) || (a <= f && b <= e)) {
            System.out.println("Дом №1 можно строить!");
        } else {
            System.out.println("дом №1 не влезет");
        }
        if ((c <= e && d <= f) || (c <= f && d <= e)) {
            System.out.println("Дом №2 можно строить!");
        } else {
            System.out.println("дом №2 не влезет");
        }
    }
}
