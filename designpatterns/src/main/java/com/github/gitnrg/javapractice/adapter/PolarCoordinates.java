package com.github.gitnrg.javapractice.adapter;

public class PolarCoordinates {
    private final int r;
    private final int theta;

    public PolarCoordinates(int r, int theta) {
        this.r = r;
        this.theta = theta;
    }

    public int getR() {
        return r;
    }

    public int getTheta() {
        return theta;
    }
}
