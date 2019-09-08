package by.rost.jd01_4;

public class ArrayCopy {
    public static void main(String[] args) {

        int[] arrayOne = new int[]{1, 3, 5, 7, 9};
        int[] arrayTwo = new int[]{2, 4, 6, 8};
        int[] arraySum = new int[arrayOne.length + arrayTwo.length];


        arrayFill(arrayOne, arrayTwo, arraySum);
        arrayPrint(arraySum);

    }
    //Вывод массива
    private static void arrayPrint(int[] arraySum) {
        for (int i = 0; i < arraySum.length; i++) {
            System.out.print(arraySum[i] + " ");
        }
    }
    //Заполнение массива
    private static void arrayFill(int[] arrayOne, int[] arrayTwo, int[] arraySum) {
        for (int i = 0, count = 0; i < arrayOne.length; i++) {

            arraySum[count] = arrayOne[i];
            count += 2;
        }
        for (int i = 0, count = 1; i < arrayTwo.length; i++) {
            arraySum[count] = arrayTwo[i];
            count += 2;
        }
    }
}
