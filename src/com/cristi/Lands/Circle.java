package com.cristi.Lands;

import com.cristi.Interfaces.IShape;

public class Circle implements IShape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double computeArea() {
        return 3.14 * Math.pow(radius, 2); // sper ca e buna formula
    }
}
