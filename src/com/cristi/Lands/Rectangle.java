package com.cristi.Lands;

import com.cristi.Interfaces.IShape;

public class Rectangle implements IShape {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double computeArea() {
        return width * length;
    }
}
