package com.sir.soir.sir2022.services;

import com.sir.soir.sir2022.model.Person;
import com.sir.soir.sir2022.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PersonServiceImplTest {

    @InjectMocks
    PersonServiceImpl personService;

    @Mock
    PersonRepository personRepository;

    @Test
    void findById() {
        //TODO : add test findById
    }

    @Test
    void savePerson() {

        //Given
        Person person = new Person("Fila", "fila@gmail.com");
        person.setId(1L);
        when(personRepository.save(any())).thenReturn(person);

        // doThrow(new RuntimeException("Error")).when(personRepository).save(any());

        //When
        Person personResponse = personService.savePerson(person);

        //Then
        assertEquals(1L, personResponse.getId());
        verify(personRepository, times(1)).save(person);
    }

    @Test
    void updatePerson() {
        //TODO: add test update
    }

    @Test
    void deletePerson() {
        //TODO  add test delete
    }

    @Test
    void findAllPersons() {
        //TODO add test findAll
    }
}