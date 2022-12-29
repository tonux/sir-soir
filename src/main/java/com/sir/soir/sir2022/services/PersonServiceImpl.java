package com.sir.soir.sir2022.services;

import com.sir.soir.sir2022.model.Person;
import com.sir.soir.sir2022.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        // check if person exists
        // Person personToUpdate = personRepository.findById(person.getId()).get();

        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }
}
