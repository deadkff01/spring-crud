package com.example.demo.service;

import com.example.demo.repository.PersonRepository;

import java.util.List;

import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person savePerson(Person person) {
        return repository.save(person);
    }

    public List<Person> savePersons(List<Person> persons) {
        return repository.saveAll(persons);
    }

    public List<Person> getPersons() {
        return repository.findAll();
    }

    public Person getPersonById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Person getPersonByName(String name) {
        return repository.findByName(name);
    }

    public String deletePerson(int id) {
        repository.deleteById(id);
        return "Person with id = " + id + " is removed!";
    }

    public Person updatePerson(Person person) {
        Person hasPerson = repository.findById(person.getId()).orElse(null);
        hasPerson.setName(person.getName());
        return repository.save(person);
    }

}