package com.cristi.Application;

import com.cristi.Entities.Person;

public class TaxCalculator {
    private double price;

    public TaxCalculator(double price) {
        this.price = price;
    }

    public double computeTax(Person person) {
        return person.computeAllSurfaceOwned() * price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
