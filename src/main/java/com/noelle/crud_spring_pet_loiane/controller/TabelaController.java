package com.noelle.crud_spring_pet_loiane.controller;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.noelle.crud_spring_pet_loiane.model.Tabela;
import com.noelle.crud_spring_pet_loiane.repository.TabelaRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/tabela")
@AllArgsConstructor
public class TabelaController {
    
    private final TabelaRepository tabelaRepository;

    @GetMapping
    public @ResponseBody List<Tabela> list() {
        return tabelaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Tabela create(@RequestBody Tabela tabela){
        // System.out.println(tabela.getNome());
        return tabelaRepository.save(tabela);
        // return ResponseEntity.status(HttpStatus.CREATED)
        //     .body(tabelaRepository.save(tabela));
    }
    // @PostMapping
    // public ResponseEntity<Tabela> create(@RequestBody Tabela tabela) {
    //     try {
    //         Tabela savedTabela = tabelaRepository.save(tabela);
    //         return new ResponseEntity<>(savedTabela, HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
}
