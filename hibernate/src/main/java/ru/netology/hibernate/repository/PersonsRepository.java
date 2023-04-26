package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.entity.PersonsPrimaryKey;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonsRepository extends JpaRepository<Persons, PersonsPrimaryKey> {

    List<Persons> findByCityOfLiving(String city);

    List<Persons> findByPersonsPrimaryKeyAgeLessThanOrderByPersonsPrimaryKeyAge(int age);

    Optional<List<Persons>> findByPersonsPrimaryKeyNameAndPersonsPrimaryKeySurname(String name, String surname);
}
