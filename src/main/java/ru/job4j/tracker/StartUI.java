package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateFormat = item.getCreated().format(formater);
        System.out.println(currentDateFormat);
    }
}
