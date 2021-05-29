package com.cristi.Screens;

import com.cristi.Interfaces.IScreen;

public class OptionsPrinter {
    private IScreen gui;

    public OptionsPrinter(IScreen gui) {
        this.gui = gui;
    }
    public void screenOne() {
        gui.printMessage("Welcome!");
        gui.printMessage("Press 1 to add a new person\n" +
                "Press 2 to remove a person\n" +
                "Press 3 to show all the persons in the list\n" +
                "Press 4 to search for a person in the list\n" +
                "Press 5 to change the price\n" +
                "Press 6 to exit.\n");
    }

    public void screenTwo() {
        gui.printMessage("Press 0 to compute the tax\n" +
                "Press 1 to add a new field\n" +
                "Press 2 to remove a field\n" +
                "Press 3 to show all the surface owned(in m^2)\n" +
                "Press 4 to show all the fields owned\n" +
                "Press 5 to exit.\n");
    }

    public void screenThree() {
        gui.printMessage("Press 1 for rectangle\n" +
                "Press 2 for circle\n");
    }
}
