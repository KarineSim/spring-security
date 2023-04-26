package ru.netology.hibernate.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.hibernate.exception.PersonNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> invalidCredentialsHandler(PersonNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
