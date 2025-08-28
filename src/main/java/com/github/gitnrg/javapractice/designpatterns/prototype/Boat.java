package com.github.gitnrg.javapractice.designpatterns.prototype;

public class Boat implements Vehicle {
    private String captain;

    public Boat(String captain) {
        this.captain = captain;
    }

    @Override
    protected Object clone() {
        return new Boat(captain);
    }

    @Override
    public String toString() {
        return "Boat{" +
                "captain='" + captain + '\'' +
                '}';
    }
}
