package com.github.gitnrg.javapractice.adapter;

public class CartesianDistanceAdapter implements DistanceAdapter {
    private final CartesianCoordinates cartesianCoordinates;

    public CartesianDistanceAdapter(CartesianCoordinates cartesianCoordinates) {
        this.cartesianCoordinates = cartesianCoordinates;
    }

    @Override
    public double getDistanceFromOrigin() {
        return Math.sqrt(Math.pow(cartesianCoordinates.getX(), 2) + Math.pow(cartesianCoordinates.getY(), 2));
    }
}
