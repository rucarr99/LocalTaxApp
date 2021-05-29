package com.cristi.Screens;

import com.cristi.Interfaces.IScreen;

import java.util.Scanner;

public class UserInterface implements IScreen {
    public static Scanner scanner = new Scanner(System.in);
    @Override
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String ReadChoice() {
        String input;
        input = scanner.next();
        return input;
    }

    public int ReadChoiceInt() {
        return scanner.nextInt();
    }

}
