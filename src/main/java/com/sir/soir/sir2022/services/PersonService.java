package com.sir.soir.sir2022.services;

import com.sir.soir.sir2022.model.Person;

import java.util.List;

public interface PersonService {

    Person findById(Long id);
    Person savePerson(Person person);
    Person updatePerson(Person person);
    void deletePerson(Person person);
    List<Person> findAllPersons();
}
