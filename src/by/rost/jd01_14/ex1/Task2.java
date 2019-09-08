package by.rost.jd01_14.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Task2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 1, 5, 7, 9, 22, 33, 35);
        Optional<Integer> average = list.stream()
                .limit(1)
                .filter(Task2::isOdd)
                .findFirst();
        average.ifPresent(System.out::println);
    }

    private static boolean isOdd(Integer it) {
        System.out.println("+");
        return it % 2 != 0;
    }
}
