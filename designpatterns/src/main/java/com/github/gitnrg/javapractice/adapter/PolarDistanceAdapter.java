package com.github.gitnrg.javapractice.adapter;

public class PolarDistanceAdapter implements DistanceAdapter {
    private final PolarCoordinates polarCoordinates;

    public PolarDistanceAdapter(PolarCoordinates polarCoordinates) {
        this.polarCoordinates = polarCoordinates;
    }

    @Override
    public double getDistanceFromOrigin() {
        return polarCoordinates.getR();
    }
}
