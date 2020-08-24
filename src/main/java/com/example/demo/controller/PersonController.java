package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping("/add-person")
    public Person addProduct(@RequestBody Person person) {
        return service.savePerson(person);
    }

    @PostMapping("/add-persons")
    public List<Person> addProducts(@RequestBody List<Person> persons) {
        return service.savePersons(persons);
    }

    @GetMapping("/get-all-persons")
    public List<Person> findAllPersons() {
        return service.getPersons();
    }

    @GetMapping("/person-by-id/{id}")
    public Person findProductById(@PathVariable int id) {
        return service.getPersonById(id);
    }

    @GetMapping("/person/{name}")
    public Person findProductByName(@PathVariable String name) {
        return service.getPersonByName(name);
    }

    @PutMapping("/update-person")
    public Person updatePerson(@RequestBody Person person) {
        return service.updatePerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id) {
        return service.deletePerson(id);
    }
}