package com.example.liquibasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class Controller {

    @Autowired
    private personRepository personRepository;

    @PostMapping("person")
    public String createPerson(@RequestParam String name) {
        personRepository.save(new Person(name));
        return personRepository.findByName(name) + "saved successfully";
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return (List<Person>) personRepository.findAll();
    }
}
