package com.cristi.Interfaces;

import com.cristi.Entities.Person;

public interface IPersonRepository {
    void add(Person person);
    void remove(Person person);
    Person findByName(String name);
    void showAll();
}
