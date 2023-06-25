package com.example.liquibasedemo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface personRepository extends CrudRepository<Person, Integer> {
    @Query(value="select name from Person p where p.name like %:personName")
    String findByName(String personName);
}
