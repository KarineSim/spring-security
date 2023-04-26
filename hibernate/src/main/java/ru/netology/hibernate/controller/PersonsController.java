package ru.netology.hibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.service.PersonsService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonsController {

    private final PersonsService personsService;

    @GetMapping("/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city) {
        return personsService.findByCityOfLiving(city);
    }

    @GetMapping("/by-age-desc")
    public List<Persons> getPersonsByAgeDesc(@RequestParam("age") int age) {
        return personsService.findByPersonsPrimaryKeyAgeLessThanOrderByPersonsPrimaryKeyAge(age);
    }

    @GetMapping("/by-name-surname")
    public Optional<List<Persons>> getPersonsByNameAndSurname(@RequestParam("name") String name,
                                                              @RequestParam("surname") String surname) {
        return personsService.findByPersonsPrimaryKeyNameAndPersonsPrimaryKeySurname(name, surname);
    }
}
