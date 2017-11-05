package com.tcs.saveperson.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.saveperson.model.Person;

public interface PersonRepository extends JpaRepository<Person
, Long>{

}