package ru.job4j.cast;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle sapsan = new Train();
        Vehicle boeing = new Plane();
        Vehicle airbus = new Plane();
        Vehicle hyundai = new Bus();
        Vehicle maz = new Bus();

        Vehicle[] vehicles = {train, sapsan, boeing, airbus, hyundai, maz};
        for (Vehicle object: vehicles) {
            object.move();
        }
    }
}
