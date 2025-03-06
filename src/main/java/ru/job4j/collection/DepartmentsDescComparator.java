package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @SuppressWarnings("checkstyle:RightCurly")
    @Override
    public int compare(String left, String right) {
        String[] lefts = left.split("/");
        String[] rights = right.split("/");
        if (lefts[0].equals(rights[0])) {
            return left.compareTo(right);
        } else {
            return right.compareTo(left);
        }
    }
}