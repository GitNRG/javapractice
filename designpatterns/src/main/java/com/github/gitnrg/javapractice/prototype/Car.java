package com.github.gitnrg.javapractice.prototype;

import java.util.Arrays;

public class Car implements Vehicle {
    private String licensePlate;
    private String[] passengers;

    public Car(String licensePlate, String[] passengers) {
        this.licensePlate = licensePlate;
        this.passengers = passengers;
    }

    @Override
    protected Object clone() {
        return  new Car(licensePlate, Arrays.copyOf(passengers, passengers.length));
    }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", passengers=" + Arrays.toString(passengers) +
                '}';
    }
}
