package com.cristi.Repositories;


import com.cristi.Interfaces.IShape;
import com.cristi.Interfaces.ILandService;
import com.cristi.Entities.Person;

public class LandRepository implements ILandService {
    private final Person person;

    public LandRepository(Person person) {
        this.person = person;
    }

    @Override
    public void add(IShape land) {
        person.addNewField(land);
    }

    @Override
    public void remove(IShape land) {
        person.removeField(land);
    }
}

