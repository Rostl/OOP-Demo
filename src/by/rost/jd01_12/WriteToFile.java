package by.rost.jd01_12;

import by.rost.jd01_12.util.WriteFileUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteToFile {
    public static void main(String[] args) {
        int countOfNumbers = 100;
        Path textPaht = Paths.get("resources", "temp", "test2.txt");
        try {
            int[] sortArrayOfValues = WriteFileUtil.createRandomSortArray(countOfNumbers);
            WriteFileUtil.writeFile(sortArrayOfValues, textPaht);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}