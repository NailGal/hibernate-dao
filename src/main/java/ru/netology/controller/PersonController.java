package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.domain.Person;
import ru.netology.repository.PersonRepository;

import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return repository.getPersonsByCity(city);
    }
}