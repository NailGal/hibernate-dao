package ru.netology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.domain.Person;
import ru.netology.domain.PersonId;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, PersonId> {
    // Найти всех жителей города (city)
    List<Person> findByCityOfLiving(String city);

    // Найти людей младше возраста (age) с сортировкой по возрасту (ASC)
    List<Person> findByAgeLessThanOrderByAgeAsc(int age);

    // Найти первого человека по имени/фамилии (с сортировкой по возрасту)
    Optional<Person> findTopByNameAndSurnameOrderByAgeAsc(String name, String surname);
}
