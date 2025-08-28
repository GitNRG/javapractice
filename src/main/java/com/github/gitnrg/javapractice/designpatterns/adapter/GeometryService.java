package com.github.gitnrg.javapractice.designpatterns.adapter;

public class GeometryService {
    public double findLongest(DistanceAdapter... args) {
        var max = Double.MIN_VALUE;
        for (var a : args) {
            if (a.getDistanceFromOrigin() > max) {
                max = a.getDistanceFromOrigin();
            }
        }
        return max;
    }
}
