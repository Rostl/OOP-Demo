package by.rost.jd01_9;

import java.util.Comparator;

public class StudentsComparatorFirstSecond implements Comparator<Student> {
    private FirstNameCompare firstNameComparator = new FirstNameCompare();
    private LastNameCompare lastNameComparator = new LastNameCompare();

    @Override
    public int compare(Student o1, Student o2) {
        int compareResult = firstNameComparator.compare(o1, o2);
        compareResult = compareResult == 0 ? lastNameComparator.compare(o1, o2) : compareResult;
        return compareResult;
    }
}
