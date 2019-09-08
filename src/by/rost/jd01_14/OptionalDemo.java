package by.rost.jd01_14;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        Student student = new Student(35, "Ivan");
        Optional.ofNullable(student)
                .map(Student::getFirstName)
                .ifPresent(System.out::println);
    }
}
