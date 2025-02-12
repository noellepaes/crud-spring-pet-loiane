package com.noelle.crud_spring_pet_loiane.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.noelle.crud_spring_pet_loiane.exception.RecordNotFoundExeption;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    
    @ExceptionHandler(RecordNotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundExeption(RecordNotFoundExeption ex){
        return ex.getMessage();
    }
}
