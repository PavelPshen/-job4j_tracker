package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-23, -4, 3, 8, 19);
        List<Integer> positive = numbers.stream().filter(
                numb -> numb > 0
        ).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}