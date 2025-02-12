package com.noelle.crud_spring_pet_loiane.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record TabelaDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Length(min= 5, max = 10)String nome,
        @NotNull @Length(max = 10) @Pattern(regexp = "back-end|front-end")String categoria) {

}
