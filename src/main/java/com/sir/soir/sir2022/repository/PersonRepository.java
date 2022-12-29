package com.sir.soir.sir2022.repository;

import com.sir.soir.sir2022.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
