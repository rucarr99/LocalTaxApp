package com.cristi.Repositories;

import com.cristi.Entities.EntityManager;
import com.cristi.Interfaces.IPersonRepository;
import com.cristi.Entities.Person;

public class PersonRepository implements IPersonRepository {
    private EntityManager entityManager;

    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Person person) {
        entityManager.addPerson(person);
    }

    @Override
    public void remove(Person person) {
        entityManager.removePerson(person);
    }

    @Override
    public Person findByName(String name) {
        return entityManager.findPersonByName(name);
    }

    @Override
    public void showAll() {
        entityManager.showAllPersons();
    }

}
