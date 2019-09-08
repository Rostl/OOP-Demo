package by.rost.jd01_9;

import java.util.Comparator;

public class AverageCompare implements Comparator <Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getAverageScope(), o2.getAverageScope());
    }
}
