package com.sir.soir.sir2022.repository;

import com.sir.soir.sir2022.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    // findByName
    List<Person> findByName(String name);
    Person findByEmail(String email);
}
