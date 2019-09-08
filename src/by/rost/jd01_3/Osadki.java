package by.rost.jd01_3;

import java.util.Scanner;

public class Osadki {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество дней!");
        int n = sc.nextInt();
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;
        int osadki = 0;


        for (int i = 1; i <= n; i++) {
            System.out.println("Введите количество осадков за " + i + " -й день");
            osadki = sc.nextInt();
            sum += osadki;
            if (maxVal < osadki) {
                maxVal = osadki;
            }

        }
        System.out.println();
        System.out.print("Сумма осадков за " + n + " д. - " + sum + " mm"); //лень писать проверку на окончания (((
        System.out.println();
        System.out.println();
        System.out.println("Среднее количество осадков за этот период - " + sum / n + " mm");
        System.out.println();
        System.out.print("Максимальное количество дневных осадков - " + maxVal + " mm");
        System.out.println();
        System.out.println();
        if (n <= 3 && (sum / n) > 200) {
            System.out.println("УРА.... теперь мы морское государство!");
        }


    }
}
