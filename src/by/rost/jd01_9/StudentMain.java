package by.rost.jd01_9;

import java.util.ArrayList;

public class StudentMain {
    public static void main(String[] args) {
        ArrayList<Student> myStudents = new ArrayList<>();
        myStudents.add(new Student("Алексей", "Иванов", 21, 5.6));
        myStudents.add(new Student("Сергей", "Харитон", 20, 8.0));
        myStudents.add(new Student("Александр", "Градский", 25, 4.2));
        myStudents.add(new Student("Андрей", "Рогов", 23, 7.2));

        System.out.println("Студент с максимальный средним баллом:");
        maxAverage(myStudents);
        System.out.println();
        System.out.println("Исходная коллекция");
        print(myStudents);
        myStudents.sort(new StudentsComparatorFirstSecond());
        System.out.println("Коллекция после сортировки по Имя + Фамилия");
        print(myStudents);
        myStudents.sort(new AgeCompare());
        System.out.println("Коллекция после сортировки по возрасту");
        print(myStudents);
        myStudents.sort(new AverageCompare());
        System.out.println("Коллекция после сортировки по среднему баллу");
        print(myStudents);
    }

    //Найти максимальное значение среднего балаа
    private static void maxAverage(ArrayList<Student> myStudents) {
        double averMax = 0;
        double average;
        int averMaxIndex = -1;
        for (int i = 1; i < myStudents.size(); i++) {
            average = myStudents.get(i).getAverageScope();
            if (average > averMax) {
                averMax = average;
                averMaxIndex = i;
            }
        }
        if (averMaxIndex > 0) {
            System.out.println(myStudents.get(averMaxIndex));
        }
    }

    //Вывод на консоль
    private static <T> void print(Iterable<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}





