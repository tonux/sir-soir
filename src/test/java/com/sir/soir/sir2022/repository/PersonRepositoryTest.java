package com.sir.soir.sir2022.repository;

import com.fasterxml.jackson.core.sym.Name;
import com.sir.soir.sir2022.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    void save() {
        //Given
        Person person = new Person("Palaye", "beugThiep@gmail.com");

        //When
        Person personResponse = personRepository.save(person);

        //Then
        assertNotNull(personResponse);
        assertTrue(personResponse.getId() > 0);
        assertEquals(personResponse.getName(), person.getName());
    }


    @Test
    void update() {
        //Given
        Person person = personRepository.save(new Person("Diallo", "diallo@gmail.com"));
        person.setName("Ba");

        //When
        Person personUpdate = personRepository.save(person);

        //Then
        assertNotNull(personUpdate);
        assertEquals(personUpdate.getName(), person.getName());
    }

    @Test
    void findByName(){
        //Given
        personRepository.save(new Person("Diallo222", "diallo@gmail.com"));

        //When
        List<Person> persons = personRepository.findByName("Diallo222");

        //Then
        assertNotNull(persons);
        assertTrue(persons.size() > 0);
        assertTrue(persons.stream().anyMatch(person -> person.getName().equals("Diallo222")));

    }




    // TODO: add test delete
    @Test
    void delete(){
        //Given
        final Long testId = 50L;
        Person person = new Person(testId,"Modou","fall");
        personRepository.save(person);

        //When
        personRepository.delete(person);

        //Then
        List<Person> persons = personRepository.findAll();
        assertTrue(persons.stream().anyMatch(pers -> pers.getId() == testId));
    }

    // TODO: add test findById
    @Test
    void findById(){
        //Given
        final Long testId = 50L;
        Person person = new Person(testId,"Ousmane","Ndiaye");
        personRepository.save(person);

        //When
        personRepository.findById(testId);

        //Then
        Person personFound = personRepository.findById(testId).orElse(null);
        assertTrue(personFound != null);
        assertTrue(personFound.getId() == testId);

    }

    // TODO: add test findAll
        @Test
    void findByAll(){
        //Given
        personRepository.save(new Person("Diagn", "diagn@gmail.com"));
        personRepository.save(new Person("Mor","Fall@gmail.com"));
        personRepository.save(new Person("Lo","lo@yopmail.com"));

        //When
        List<Person> persons = personRepository.findAll();

        //Then
        assertNotNull(persons);
        assertTrue(persons.size() >= 3);
        assertTrue(persons.stream().anyMatch(person -> person.getName().equals("Diagn")));
        assertTrue(persons.stream().anyMatch(person -> person.getName().equals("Mor")));
        assertTrue(persons.stream().anyMatch(person -> person.getName().equals("Lo")));

    }

}