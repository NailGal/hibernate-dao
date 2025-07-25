package ru.netology.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSONS")
@IdClass(PersonId.class)
public class Person {
    @Id
    @Column(nullable = false)
    private String name;

    @Id
    @Column(nullable = false)
    private String surname;

    @Id
    @Column(nullable = false)
    private int age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city_of_living", nullable = false)
    private String cityOfLiving;
}