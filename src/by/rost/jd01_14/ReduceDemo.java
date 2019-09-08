package by.rost.jd01_14;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceDemo {

    public static void main(String[] args) {
        int reduce = IntStream.of(1, 4, 5, 6, 7)
                .reduce(0, (acc, right) -> acc + right);
        System.out.println(reduce);
    }
}
