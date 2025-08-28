package com.github.gitnrg.javapractice.designpatterns.adapter;

public class CartesianCoordinates {
    private final int x;
    private final int y;

    public CartesianCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
