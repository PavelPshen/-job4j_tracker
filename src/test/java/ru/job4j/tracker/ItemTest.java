package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("abd"),
                new Item("abc"),
                new Item("deb"),
                new Item("zet")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("zet"),
                new Item("deb"),
                new Item("abd"),
                new Item("abc")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("abd"),
                new Item("abc"),
                new Item("deb"),
                new Item("zet")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("abc"),
                new Item("abd"),
                new Item("deb"),
                new Item("zet")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenItemSortById() {
        List<Item> items = Arrays.asList(
                new Item(2, "abd"),
                new Item(1, "abc"),
                new Item(3, "deb"),
                new Item(4, "zet")
        );
        Collections.sort(items);
        List<Item> expected = Arrays.asList(
                new Item(1, "abc"),
                new Item(2, "abd"),
                new Item(3, "deb"),
                new Item(4, "zet")
        );
        assertThat(items).isEqualTo(expected);
    }

}