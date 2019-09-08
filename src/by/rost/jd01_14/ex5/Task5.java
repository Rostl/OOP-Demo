package by.rost.jd01_14.ex5;

import by.itacademy.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task5 {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(18, "Брюс", "Ли"),
                new Student(18, "Ivan", "Ivanov"),
                new Student(30, "Petr", "Petrov"),
                new Student(50, "Sidor", "Sidorov"),
                new Student(40, "Sidor", "SidorovSidorov")
        );

        students.stream()
                .filter(person -> person.fullName().length() < 15)
                .max(Comparator.comparing(Student::getAge).reversed())
                .ifPresent(System.out::println);
    }
}
