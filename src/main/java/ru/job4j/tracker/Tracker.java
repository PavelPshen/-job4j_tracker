package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tracker tracker = (Tracker) o;
        return ids == tracker.ids && size == tracker.size && Arrays.equals(items, tracker.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(ids, size);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] result = new Item[items.length];
        size = 0;
        for (Item item : items) {
            if (item != null) {
                result[size++] = item;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    public Item[] findByName(String key) {
        Item[] resultAll = findAll();
        Item[] resultName = new Item[resultAll.length];
        size = 0;
        for (Item item : resultAll) {
            if (item.getName().equals(key)) {
                resultName[size++] = item;
            }
        }
        resultName = Arrays.copyOf(resultName, size);
        return resultName;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}