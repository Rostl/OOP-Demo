package by.rost.jd01_19.pattern.builder;

public class BuilderDemo {

    public static void main(String[] args) {
        Student student = Student.getBuilder()
                .age(25)
                .name("Ivan")
                .gender(Gender.FEMALE)
                .build();

        System.out.println(student);
    }
}
