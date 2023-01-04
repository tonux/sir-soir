package com.sir.soir.sir2022.controller;


import com.sir.soir.sir2022.model.Person;
import com.sir.soir.sir2022.services.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    /**
     *  GET /api/person
     *  GET /api/person/{id}
     *  POST /api/person
     *  PUT /api/person/{id}
     *  DELETE /api/person/{id}
     */

    PersonService personService;

    private static Logger logger = LogManager.getLogger(PersonController.class);

    public PersonController(PersonService personService) {
        logger.info("PersonController constructor");
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        logger.info("===> getAllPersons");
        return ResponseEntity.ok(personService.findAllPersons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(Person person) {
        logger.info("===> savePerson");
        return ResponseEntity.ok(personService.savePerson(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(Person person) {
        return ResponseEntity.ok(personService.updatePerson(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(Person person) {
        personService.deletePerson(person);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name;
    }
}
