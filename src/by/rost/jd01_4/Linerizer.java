package by.rost.jd01_4;

public class Linerizer {
    public static void main(String[] args) {


        int arrayLenght = 0;
        int count = 0;
        int[][] currentArray = {{1, 3, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 6}, {5, 4, 3, 2, 1}};
        printArray(linerize(getArrayLenght(arrayLenght, currentArray), currentArray));

    }

    public static void printArray(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i]);
        }
    }
    //Записываем все элементы с двумерного массива в одномерный
    private static int[] linerize(int arrayLenght, int[][] currentArray) {
        int arrayValue = 0;
        int[] linerizedArray = new int[arrayLenght];
        int count;
        for (int i = 0; i < currentArray.length; i++) {
            for (int j = 0; j < currentArray[i].length; j++) {
                count = currentArray[i][j];
                linerizedArray[arrayValue] = count;
                arrayValue++;
            }
        }
        return linerizedArray;
    }
        //Определяем длинну нового массива
    private static int getArrayLenght(int arrayLenght, int[][] currentArray) {
        for (int i = 0; i < currentArray.length; i++) {
            for (int j = 0; j < currentArray[i].length; j++) {
                arrayLenght += 1;
            }
        }
        return arrayLenght;
    }
}
