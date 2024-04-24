package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Едем по маршруту");
    }

    @Override
    public void passengers(int quantity) {
        System.out.printf("везем %d пассажиров", quantity);
    }

    @Override
    public double refill(int liters) {
        return Transport.super.refill(liters);
    }
}
