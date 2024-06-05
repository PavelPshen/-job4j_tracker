package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    List<Item> items = new ArrayList<>();
    private int ids = 1;

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        List<Item> result = new ArrayList<>(items);
        return result;
    }

    public List<Item> findByName(String key) {
        List<Item> resultName = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                resultName.add(item);
            }
        }
        return resultName;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
    }
}