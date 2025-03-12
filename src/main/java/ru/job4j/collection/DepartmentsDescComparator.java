package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] lefts = left.split("/");
        String[] rights = right.split("/");
        int result = rights[0].compareTo(lefts[0]);
        return result != 0 ? result : left.compareTo(right);
        }
}