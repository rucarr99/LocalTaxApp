package com.cristi.Entities;


import com.cristi.Interfaces.IScreen;
import com.cristi.Interfaces.IShape;
import com.cristi.Screens.UserInterface;

import java.util.ArrayList;

public class Person {
    private String name;
    private IScreen gui = new UserInterface();
    private ArrayList<IShape> listOfLands;

    public Person(String name) {
        this.name = name;
        this.listOfLands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void addNewField(IShape land) {
        listOfLands.add(land);
        gui.printMessage("field has been added");
    }

    public void removeField(IShape land) {
        listOfLands.remove(land);
        gui.printMessage("field has been removed");
    }
    public void showAllFields() {
        for (int i = 0; i < listOfLands.size(); i++) {
            gui.printMessage("Field " + (i + 1) + " has " + listOfLands.get(i).computeArea() + " m^2");
        }
    }

    public double computeAllSurfaceOwned() {
        double total = 0;
        for (IShape listOfLand : listOfLands) {
            total += listOfLand.computeArea();
        }
        return total;
    }

    public IShape selectField(int i) {
        return listOfLands.get(i);
    }
}


