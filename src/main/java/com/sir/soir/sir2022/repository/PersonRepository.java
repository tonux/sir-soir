package com.sir.soir.sir2022.repository;

import com.sir.soir.sir2022.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    // findByName
    List<Person> findByName(String name);
}
