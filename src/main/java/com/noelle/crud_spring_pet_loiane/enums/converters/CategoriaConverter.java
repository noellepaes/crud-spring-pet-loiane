package com.noelle.crud_spring_pet_loiane.enums.converters;

import com.noelle.crud_spring_pet_loiane.enums.Categoria;

import java.util.stream.Stream;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoriaConverter implements AttributeConverter<Categoria, String>{

    @Override
    public String convertToDatabaseColumn(Categoria categoria) {
       
        if (categoria ==null){
            return null;
        }
        return categoria.getValue();
    }

    @Override
    public Categoria convertToEntityAttribute(String value) {
       
        if (value ==null){
            return null;
        }
        return Stream.of(Categoria.values())
                 .filter(c -> c.getValue().equals(value))
                 .findFirst() 
                 .orElseThrow(IllegalArgumentException::new)  ;
    }
    
}
