package com.cristi.Application;


import com.cristi.Entities.EntityManager;
import com.cristi.Entities.Person;
import com.cristi.Interfaces.IScreen;
import com.cristi.Lands.Circle;
import com.cristi.Lands.Rectangle;
import com.cristi.Repositories.LandRepository;
import com.cristi.Repositories.PersonRepository;
import com.cristi.Screens.OptionsPrinter;

public class  Application {
    private IScreen gui;
    private EntityManager entityManager;
    private PersonRepository personRepository;
    private OptionsPrinter optionsPrinter;
    private TaxCalculator taxCalculator;
    private LandRepository landRepository;

    public Application(IScreen gui) {
        this.gui = gui;
        this.entityManager = new EntityManager(gui);
        this.personRepository = new PersonRepository(entityManager);
        this.optionsPrinter = new OptionsPrinter(gui);
        this.taxCalculator = new TaxCalculator(0.1);
    }

    public void start() {
        int userInput;
        boolean quit = false;

        while (!quit) {
            optionsPrinter.screenOne();
            gui.printMessage("Enter your choice");
            userInput = gui.ReadChoiceInt();
            switch (userInput) {
                case 1:
                    gui.clearScreen();
                    addPerson();
                    break;
                case 2:
                    gui.clearScreen();
                    removePerson();
                    break;
                case 3:
                    gui.clearScreen();
                    personRepository.showAll();
                    break;
                case 4:
                    gui.clearScreen();
                    queryPerson();
                    break;
                case 5:
                    gui.clearScreen();
                    changePrice();
                    break;
                case 6:
                    gui.clearScreen();
                    quit = true;
                    break;
            }

        }
    }

    private void addPerson() {
        gui.printMessage("Enter the name of the person: ");
        String personName = gui.ReadChoice();
        if (entityManager.findPersonByName(personName) != null) {
            gui.printMessage("Error");
        } else {
            Person person = new Person(personName);
            personRepository.add(person);
            gui.printMessage("Do you want to add a field to this person? Y/N");
            boolean quit = false;
            while (!quit) {
                String userInput = gui.ReadChoice();
                switch (userInput) {
                    case "Y":
                        addNewField(person);
                        gui.printMessage("Do you want to add other field? Y/N");
                        break;
                    case "N":
                        quit = true;
                        break;
                }
            }
        }
    }


    private void removePerson() {
        gui.printMessage("Enter the name of the person");
        String name = gui.ReadChoice();
        Person existingPersonRecord = personRepository.findByName(name);
        if (existingPersonRecord == null) {
            gui.printMessage("Person couldn't be found");
            return;
        }
        personRepository.remove(existingPersonRecord);
        gui.printMessage("Person was deleted successfully");
    }


    private void queryPerson() {
        gui.printMessage("Enter the name of the person\n");
        String name = gui.ReadChoice();
        Person existingPersonRecord = personRepository.findByName(name);
        if (existingPersonRecord == null) {
            gui.printMessage("Person couldn't be found\n");
            return;
        }
        landRepository = new LandRepository(existingPersonRecord);
        boolean quit = false;
        optionsPrinter.screenTwo();
        while (!quit) {
            gui.printMessage("Enter your choice: ");
            int userChoice = gui.ReadChoiceInt();
            switch (userChoice) {
                case 0:
                    gui.clearScreen();
                    gui.printMessage(taxCalculator.computeTax(existingPersonRecord) + " lei\n");
                    break;
                case 1:
                    gui.clearScreen();
                    addNewField(existingPersonRecord);
                    break;
                case 2:
                    gui.clearScreen();
                    gui.printMessage("Please enter the index of the field you want to delete\n");
                    int i = gui.ReadChoiceInt();
                    landRepository.remove(existingPersonRecord.selectField(i - 1));
                    break;
                case 3:
                    gui.clearScreen();
                    gui.printMessage(String.valueOf(existingPersonRecord.computeAllSurfaceOwned()));
                    break;
                case 4:
                    gui.clearScreen();
                    existingPersonRecord.showAllFields();
                    break;
                case 5:
                    gui.clearScreen();
                    quit = true;
                    optionsPrinter.screenOne();
                    break;
            }
        }
    }

    private void changePrice() {
        gui.printMessage("Enter the new price\n");
        int newPrice = gui.ReadChoiceInt();
        taxCalculator.setPrice(newPrice);
    }

    private void addNewField(Person person) {
        landRepository = new LandRepository(person);
        optionsPrinter.screenThree();
        int userChoice = gui.ReadChoiceInt();
        switch (userChoice) {
            case 1:
                gui.printMessage("Please enter length and width: ");
                int length = gui.ReadChoiceInt();
                int width = gui.ReadChoiceInt();
                landRepository.add(new Rectangle(length, width));
                break;
            case 2:
                gui.printMessage("Please enter the radius: ");
                int radius = gui.ReadChoiceInt();
                landRepository.add(new Circle(radius));
                break;
        }
    }
}

