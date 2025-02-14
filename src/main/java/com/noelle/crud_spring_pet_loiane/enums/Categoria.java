package com.noelle.crud_spring_pet_loiane.enums;

public enum Categoria {
    BACKEND("Back-end"), FRONTEND("Front-end");

    private String value;
    
    private Categoria(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    
}