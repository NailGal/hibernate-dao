package ru.netology.controller;

import org.springframework.http.ResponseEntity;
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

    // Существующий метод
    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return repository.findByCityOfLiving(city);
    }

    // Новый метод: поиск по возрасту
    @GetMapping("/persons/by-age-less-than")
    public List<Person> getPersonsByAgeLessThan(@RequestParam("age") int age) {
        return repository.findByAgeLessThanOrderByAgeAsc(age);
    }

    // Новый метод: поиск по имени и фамилии
    @GetMapping("/persons/by-name-and-surname")
    public ResponseEntity<Person> getPersonByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname
    ) {
        return repository.findTopByNameAndSurnameOrderByAgeAsc(name, surname)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}