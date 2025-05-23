package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combineName = persons -> persons.getName().contains(key);
        Predicate<Person> combineSurname = persons -> persons.getSurname().contains(key);
        Predicate<Person> combineAddress = persons -> persons.getAddress().contains(key);
        Predicate<Person> combinePhone = persons -> persons.getPhone().contains(key);
        Predicate<Person> combine = combineName.or(combineSurname).or(combineAddress.or(combinePhone));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
