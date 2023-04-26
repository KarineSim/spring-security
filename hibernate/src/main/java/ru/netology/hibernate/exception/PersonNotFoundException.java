package ru.netology.hibernate.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String msg) {
        super(msg);
    }
}
