package com.noelle.crud_spring_pet_loiane.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/tabela")
@AllArgsConstructor
public class TabelaController {
    
    private final TabelaRepository tabelaRepository;

    @GetMapping
    public @ResponseBody List<Tabela> list() {
        return tabelaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tabela> findbyId(@PathVariable Long id) {
        return tabelaRepository.findById(id)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
    }
    

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Tabela create(@RequestBody Tabela tabela){
        // System.out.println(tabela.getNome());
        return tabelaRepository.save(tabela);
        // return ResponseEntity.status(HttpStatus.CREATED)
        //     .body(tabelaRepository.save(tabela));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tabela> update(@PathVariable Long id,
     @RequestBody Tabela tabela) {
        return tabelaRepository.findById(id)
        .map(recordFound -> {
            recordFound.setNome(tabela.getNome());
            recordFound.setCategoria(tabela.getCategoria());
            Tabela updated = tabelaRepository.save(recordFound);
            return ResponseEntity.ok().body(updated);
        })
        .orElse(ResponseEntity.notFound().build());
    }
}
