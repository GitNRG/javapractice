package com.github.gitnrg.javapractice.adapter;

public class Main {
    public static void main(String[] args) {
        var cartesian = new CartesianCoordinates(3, 4); // length 5.0
        var polar = new PolarCoordinates(7, 34); // length 7.0

        var cartesianAdapter = new CartesianDistanceAdapter(cartesian);
        var polarAdapter = new PolarDistanceAdapter(polar);

        var service = new GeometryService();
        var longest = service.findLongest(cartesianAdapter, polarAdapter);
        System.out.println(longest); // 7.0
    }
}
