package com.cristi.Entities;

import com.cristi.Entities.Person;
import com.cristi.Interfaces.IScreen;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Person> listOfPersons;
    private IScreen gui;

    public EntityManager(IScreen gui) {
        this.listOfPersons = new ArrayList<>();
        this.gui = gui;
    }


    public void addPerson(Person person) {
        if (findPersonByName(person.getName()) != null) {
            gui.printMessage("Person already exists");
            return;
        }
        gui.printMessage(person.getName() + " has been added");
        listOfPersons.add(person);
    }


    public void removePerson(Person person) {
        if(findPersonByName(person.getName()) == null) {
            gui.printMessage("Person doesn't exist.");
        } else {
            gui.printMessage(person.getName() + " has been removed");
            listOfPersons.remove(person);
        }
    }

    public Person findPersonByName(String name) {
        for(Person person : listOfPersons) {
            if(person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public void showAllPersons() {
        for(int i = 0; i < listOfPersons.size(); i++) {
            gui.printMessage((i+1) + " " + this.listOfPersons.get(i).getName());
        }
    }


}
