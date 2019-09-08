package by.rost.jd01_14.ex5;

import by.itacademy.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;

public class Task7 {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(18, "Брюс", "Ли"),
                new Student(18, "Ivan", "Ivanov"),
                new Student(30, "Petr", "Petrov"),
                new Student(50, "Sidor", "Sidorov"),
                new Student(40, "Sidor", "SidorovSidorov")
        );

        Map<String, Student> collect = students.parallelStream()
                .peek(it -> System.out.println(Thread.currentThread().getName() + " " + it))
                .sequential()
                .collect(Collectors.toMap(Student::getFirstName, identity(),
                        (first, second) -> first.getAge() > second.getAge() ? first : second
                ));

//        System.out.println(collect);
    }
}