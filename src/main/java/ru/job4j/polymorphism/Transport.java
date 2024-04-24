package ru.job4j.polymorphism;

public interface Transport {
    void drive();

    void passengers(int quantity);

    default double refill(int liters) {
        return liters * 55;
    }
}
