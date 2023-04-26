package ru.netology.hibernate.repository;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.entity.PersonsPrimaryKey;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@AllArgsConstructor
@Component
public class CommandLineApp implements CommandLineRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        Persons personPetr = Persons.builder()
                .personsPrimaryKey(PersonsPrimaryKey.builder()
                        .name("Petr")
                        .surname("Petrov")
                        .age(30)
                        .build())
                .phoneNumber("89122222222")
                .cityOfLiving("Moscow")
                .build();

        Persons personSemen = Persons.builder()
                .personsPrimaryKey(PersonsPrimaryKey.builder()
                        .name("Semen")
                        .surname("Semenov")
                        .age(25)
                        .build())
                .phoneNumber("89123333333")
                .cityOfLiving("Yekaterinburg")
                .build();

        Persons personAlexey = Persons.builder()
                .personsPrimaryKey(PersonsPrimaryKey.builder()
                        .name("Alexey")
                        .surname("Alexeev")
                        .age(32)
                        .build())
                .phoneNumber("89124444444")
                .cityOfLiving("Moscow")
                .build();

//        entityManager.persist(personPetr);
//        entityManager.persist(personSemen);
//        entityManager.persist(personAlexey);
    }
}