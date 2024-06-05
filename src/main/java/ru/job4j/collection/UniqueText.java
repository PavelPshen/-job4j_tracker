package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        check.addAll(Arrays.asList(origin));
        for (String tex : text) {
            result = check.contains(tex);
            if (!result) {
                break;
            }
        }
        return result;
    }
}