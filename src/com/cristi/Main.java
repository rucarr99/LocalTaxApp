package com.cristi;

import com.cristi.Application.Application;
import com.cristi.Interfaces.IScreen;
import com.cristi.Screens.UserInterface;

public class Main {

    public static void main(String[] args) {
        IScreen gui = new UserInterface();
        Application application = new Application(gui);
        application.start();
    }
}
