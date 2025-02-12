package com.noelle.crud_spring_pet_loiane.model;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Length(min= 5, max = 10)
    @Column(length = 200, nullable = false)
    private String nome;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "back-end|front-end")
    @Column(length = 10, nullable = false)
    private String categoria;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false)
    @JsonIgnore
    private String status = "Ativo";
}
