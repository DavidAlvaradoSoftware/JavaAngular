package com.example.revature.bookstore.exceptions;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> invalidRequest(Exception message) {
        return ResponseEntity.badRequest().body(message.getMessage());
    }

    @ExceptionHandler(BookStoreExceptions.class)
    public ResponseEntity<String> resourceNotFound(Exception message) {
        return ResponseEntity.badRequest().body(message.getMessage());
    }


}
