package by.rost.jd01_3;

import java.util.Scanner;

public class Fibonachi {
    public static void main(String[] args) {

        int fib = 0;
        int b = 0;
        int c = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число!");
        int a = sc.nextInt();
        System.out.println("Через цикл:");
        numOfFibonachi(fib, a, b, c);
        fib = 0;
        System.out.println("Через рекурсию:");
        System.out.println(numOfFibonachiRec(fib, a, b, c));

    }

    public static void numOfFibonachi(int fib, int a, int b, int c) {
        System.out.print(fib + " ");

        while (fib < a) {

            fib = b + c;
            c = b;
            b = fib;
            if (fib < a) {
                System.out.print(fib + " ");
            }
        }
        System.out.println();

    }

    public static int numOfFibonachiRec(int fib, int a, int b, int c) {

        if (fib == 0) {
            System.out.print(fib + " ");
        }


        fib = b + c;
        c = b;
        b = fib;
        if (fib + c < a) {
            System.out.print(fib + " ");
        }
        if (fib + c >= a) {
            return fib;
        }
        return numOfFibonachiRec(fib, a, b, c);
    }

}
