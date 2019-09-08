package by.rost.jd01_12.util;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;

public class WriteFileUtil {
    /*
     * Создает массив целых чисел и сортирует его по возрастанию
     * */
    public static int[] createRandomSortArray(int count) {
        int[] arr = new int[count];
        Random randomValues = new Random();
        for (int i = 0; i < count; i++) {
            int myRandomvalue = randomValues.nextInt(200);
            arr[i] = myRandomvalue;
        }
        Arrays.sort(arr);
        return arr;
    }

    /*
     * Записывает массив в файл
     * */
    public static void writeFile(int[] sortArrayOfValues, Path textPath) throws IOException {
        try (BufferedWriter numberWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(textPath.toFile())))) {
            for (int i = 0; i < sortArrayOfValues.length; i++) {
                String chAtRandomvalue = String.valueOf(sortArrayOfValues[i]);
                numberWriter.append(chAtRandomvalue);
                numberWriter.append(" ");
            }
        }
    }
}