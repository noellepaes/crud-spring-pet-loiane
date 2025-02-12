package com.noelle.crud_spring_pet_loiane.exception;

public class RecordNotFoundExeption extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public RecordNotFoundExeption(Long id){
        super("Curso não encontrado com o id: " + id);
    }
}
