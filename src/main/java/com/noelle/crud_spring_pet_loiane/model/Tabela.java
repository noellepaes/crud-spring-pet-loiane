package com.noelle.crud_spring_pet_loiane.model;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.noelle.crud_spring_pet_loiane.enums.Categoria;
import com.noelle.crud_spring_pet_loiane.enums.converters.CategoriaConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity

// @SQLDelete(sql = "UPDATE Course SET status = 'Inativo' WHERE id = ?")
// @Where(clause = "status = 'Ativo'")
public class Tabela {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(min= 5, max = 225)
    @Column(length = 200, nullable = false)
    private String nome;

    @NotNull
    @Column(length = 10, nullable = false)
    @Convert(converter = CategoriaConverter.class)
    private Categoria categoria;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false)
    @JsonIgnore
    private String status = "Ativo";
}
