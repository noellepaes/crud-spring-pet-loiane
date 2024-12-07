package com.noelle.crud_spring_pet_loiane.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.noelle.crud_spring_pet_loiane.model.Tabela;
import com.noelle.crud_spring_pet_loiane.repository.TabelaRepository;
import com.noelle.crud_spring_pet_loiane.service.TabelaService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/tabela")
public class TabelaController {
    
    private final TabelaService tabelaService;

    public TabelaController( TabelaService tabelaService){
        this.tabelaService = tabelaService;
    }

    @GetMapping
    public @ResponseBody List<Tabela> list() {
        return tabelaService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tabela> findbyId(@PathVariable @NotNull @Positive Long id) {
        return tabelaService.findbyId(id)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Tabela create(@RequestBody @Valid Tabela tabela){
        // System.out.println(tabela.getNome());
        return tabelaService.create(tabela);
        // return ResponseEntity.status(HttpStatus.CREATED)
        //     .body(tabelaRepository.save(tabela));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tabela> update(@PathVariable Long id,
     @RequestBody Tabela tabela) {
        return tabelaService.update(id, tabela)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id) {
        if(tabelaService.delete(id)) {
        return ResponseEntity.noContent().<Void>build();
        }
        return ResponseEntity.notFound().build();
    }
}
