package by.rost.jd01_14.ex5;

import by.itacademy.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task6 {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(18, "Брюс", "Ли"),
                new Student(18, "Ivan", "Ivanov"),
                new Student(30, "Petr", "Petrov"),
                new Student(50, "Sidor", "Sidorov"),
                new Student(40, "Sidor", "SidorovSidorov")
        );

        Map<String, Set<String>> collect = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFirstName,
                        Collectors.mapping(Student::fullName, Collectors.toSet())
                ));

        System.out.println(collect);
    }
}
