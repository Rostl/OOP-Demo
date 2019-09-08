package by.rost.jd01_14.ex1;



import by.rost.jd01_14.Student;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class Task1 {

    public static void main(String[] args) {
//        List<Student> students = Arrays.asList(new Student(12, "Ivan"), new Student(45, "Pter"));
//        students.stream()
//                .filter(getStudentPredicate());


        List<Integer> list = Arrays.asList(1, 2, 5, 7, 9, 22, 33, 35);
        OptionalDouble average = list.stream()
                .filter(Task1::isOdd)
                .sorted()
                .filter(Task1::isDividedOnFive)
                .mapToInt(Integer::intValue)
                .average();
        average.ifPresent(System.out::println);

    }

    private static Predicate<Student> getStudentPredicate() {
        return it -> {
            // TODO: 15.08.2018
            System.out.println();
            return checkItem(it.getAge(), it.getFirstName());
        };
    }

    //    private static Predicate<Integer> isOdd() {
//        return (it) -> it % 2 != 0;
//    }
    private static boolean checkItem(Integer age, String name) {
        return true;
    }

    private static boolean isDividedOnFive(Integer it) {
        System.out.println("-");
        return it % 5 == 0;
    }

    private static boolean isOdd(Integer it) {
        System.out.println("+");
        return it % 2 != 0;
    }
}
