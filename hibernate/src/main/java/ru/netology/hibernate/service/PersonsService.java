package ru.netology.hibernate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.entity.PersonsPrimaryKey;
import ru.netology.hibernate.exception.PersonNotFoundException;
import ru.netology.hibernate.repository.PersonsRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonsService {

    private final PersonsRepository personsRepository;

    public List<Persons> findByCityOfLiving(String city) {
        return personsRepository.findByCityOfLiving(city);
    }

    public List<Persons> findByPersonsPrimaryKeyAgeLessThanOrderByPersonsPrimaryKeyAge(int age) {
        return personsRepository.findByPersonsPrimaryKeyAgeLessThanOrderByPersonsPrimaryKeyAge(age);
    }

    public Optional<List<Persons>> findByPersonsPrimaryKeyNameAndPersonsPrimaryKeySurname(String name, String surname) {
        return personsRepository.findByPersonsPrimaryKeyNameAndPersonsPrimaryKeySurname(name, surname);
    }

    public Persons save(Persons person) {
        return personsRepository.save(person);
    }

    public Persons findById(PersonsPrimaryKey personsPrimaryKey) {
        Optional<Persons> person = personsRepository.findById(personsPrimaryKey);
        if (person.isPresent()) {
            return person.get();
        } else {
            throw new PersonNotFoundException("Person not found");
        }
    }

    public Persons update(PersonsPrimaryKey personsPrimaryKey, Persons person) {
        Optional<Persons> updatePerson = personsRepository.findById(personsPrimaryKey);
        if (updatePerson.isPresent()) {
            updatePerson.get().setPhoneNumber(person.getPhoneNumber());
            updatePerson.get().setCityOfLiving(person.getCityOfLiving());
            personsRepository.save(updatePerson.get());
        } else {
            throw new PersonNotFoundException("Person not found");
        }
        return updatePerson.get();
    }

    public String delete(PersonsPrimaryKey personsPrimaryKey) {
        Optional<Persons> deletePerson = personsRepository.findById(personsPrimaryKey);
        if (deletePerson.isPresent()) {
            personsRepository.delete(deletePerson.get());
            return "Person deleted";
        } else {
            throw new PersonNotFoundException("Person not found");
        }
    }
}
