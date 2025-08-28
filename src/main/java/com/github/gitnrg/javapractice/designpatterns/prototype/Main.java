package com.github.gitnrg.javapractice.designpatterns.prototype;

public class Main {
    public static void main(String[] args) {
        var car = new Car("A123X", new String[]{"Luke", "Christy"});
        var boat = new Boat("Capt. Michael Seaworthy");
        System.out.println(car.clone());
        System.out.println(boat.clone());
    }
}
