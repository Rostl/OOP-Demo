package by.rost.jd01_9;

public class Student {
    private String name;
    private String lastName;
    private int age;
    private double averageScope;

    public Student(String name, String lastName, int age, double averageScope) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.averageScope = averageScope;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "firstName='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age + '\'' +
                ", averageScope=" + averageScope + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getAverageScope() {
        return averageScope;
    }
}