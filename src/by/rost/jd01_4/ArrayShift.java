package by.rost.jd01_4;

import java.util.Random;
import java.util.Scanner;

public class ArrayShift {
    public static void main(String[] args) {

        Random randomValue = new Random();
        int[] arrOfRandoms = arrayFirstCreator(randomValue);
        Scanner arrayShiftNumber = new Scanner(System.in);
        System.out.println("Введите количество сдвигов массива");
        int numberOfTimes = arrayShiftNumber.nextInt();

        System.out.println("Исходный массив:");
        for (int i = 0; i < arrOfRandoms.length; i++) {
            System.out.print("\'" + arrOfRandoms[i] + "\'" + " ");
        }

        System.out.println();
        System.out.println();
        for (int times = 1; times <= numberOfTimes ; times++) {
            arrayShifter(arrOfRandoms);
            arrayPriner(arrOfRandoms);
        }

    }
    //Создаем рандомный массив
    private static int[] arrayFirstCreator(Random randomValue) {
        int[] arrOfRandoms = new int[10];
        for (int i = 0; i < arrOfRandoms.length; i++) {
            arrOfRandoms[i] = randomValue.nextInt(100) + 1;
        }
        return arrOfRandoms;
    }
    //Сдвигаем элементы массива
    private static void arrayShifter(int[] arrOfRandoms) {
        int currentValue = 0;
        int nextValue = 0;
        int lastIndex = arrOfRandoms[arrOfRandoms.length - 1];
        for (int i = arrOfRandoms.length - 1; i > 0; i--) {

            arrOfRandoms[i] = arrOfRandoms[i - 1];

        }
        arrOfRandoms[0] = lastIndex;
    }
        //вывод массива
    private static void arrayPriner(int[] arrOfRandoms) {

            System.out.println("Вывод массива со сдвигом вправо...");
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < arrOfRandoms.length; i++) {

                System.out.printf("\'%s\' ","\'" + arrOfRandoms[i]);
            }
        System.out.println();

        }

    }




