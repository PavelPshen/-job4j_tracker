package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        System.out.println("without matching keys: ");
        map.put("pshen-leti@mail.ru", "Pavel Pshenitsyn");
        map.put("RuPost@yandex.ru", "Ivan Ivanov");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
        map.clear();
        System.out.println("with matching keys");
        map.put("pshen-leti@mail.ru", "Pavel Pshenitsyn");
        map.put("RuPost@yandex.ru", "Ivan Ivanov");
        map.put("pshen-leti@mail.ru", "Ivan Petrov");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
