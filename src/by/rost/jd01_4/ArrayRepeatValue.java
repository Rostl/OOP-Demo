package by.rost.jd01_4;

public class ArrayRepeatValue {
    public static void main(String[] args) {

        int[] array = new int[]{5,8,1,5,8,2,5,21,90,1};

        int currentValue  = 0;
        int copyValue = 0;


        repeatDelete(array);
        arrayPrint(array);

    }

    private static void arrayPrint(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    //Обнуляем повторяющиеся элементы
    private static void repeatDelete(int[] array) {
        int currentValue;
        int copyValue;
        for (int i = 0; i < array.length - 1; i++) {
            currentValue = array[i];
            for (int j = i + 1; j < array.length; j++) {
                copyValue = array[j];
                if (currentValue == 0) {
                    break;
                }
                if (currentValue == copyValue) {
                    array[j] = 0;
                }
            }
        }
    }
}
