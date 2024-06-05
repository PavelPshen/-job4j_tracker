package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public HashSet<String> extractNumber(List<Task> tasks) {
        HashSet<String> number = new HashSet<>();
        for (Task task : tasks) {
            number.add(task.getNumber());
        }
        return number;
    }
}
