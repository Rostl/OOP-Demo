package by.rost.jd01_9;

import java.util.Comparator;

public class LastNameCompare implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
