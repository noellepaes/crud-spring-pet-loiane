package com.noelle.crud_spring_pet_loiane.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noelle.crud_spring_pet_loiane.model.Tabela;
import com.noelle.crud_spring_pet_loiane.repository.TabelaRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/tabela")
@AllArgsConstructor
public class TabelaController {
    
    private final TabelaRepository tabelaRepository;

    @GetMapping
    public List<Tabela> list() {
        return tabelaRepository.findAll();
    }
}
