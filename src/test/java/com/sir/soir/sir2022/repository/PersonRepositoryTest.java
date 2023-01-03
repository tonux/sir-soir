package com.sir.soir.sir2022.repository;

import com.sir.soir.sir2022.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        List<Person> persons = personRepository.findByName("Diallo");

        //Then
        assertNotNull(persons);
        assertTrue(persons.size() > 0);
        assertTrue(persons.stream().anyMatch(person -> person.getName().equals("Diallo")));

    }


    // TODO: add test delete

    // TODO: add test findById

    // TODO: add test findAll

}