package com.noelle.crud_spring_pet_loiane.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.noelle.crud_spring_pet_loiane.model.Tabela;
import com.noelle.crud_spring_pet_loiane.repository.TabelaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class TabelaService {
    
    private final TabelaRepository tabelaRepository;

    public TabelaService(TabelaRepository tabelaRepository){
        this.tabelaRepository = tabelaRepository;
    }

    public List<Tabela> list() {
        return tabelaRepository.findAll();
    }

    public Optional<Tabela> findbyId(@PathVariable @NotNull @Positive Long id) {
        return tabelaRepository.findById(id);
    }

    public Tabela create(@RequestBody Tabela tabela){
        return tabelaRepository.save(tabela);
    }

    public Optional<Tabela> update(@PathVariable Long id, @Valid Tabela tabela) {
       return tabelaRepository.findById(id)
       .map(recordFound -> {
           recordFound.setNome(tabela.getNome());
           recordFound.setCategoria(tabela.getCategoria());
           return tabelaRepository.save(recordFound);
           
       });
   }

   public boolean delete(@PathVariable @NotNull @Positive Long id) {
    return tabelaRepository.findById(id)
    .map(recordFound -> {
        tabelaRepository.deleteById(id);

        return true;
    })
    .orElse(false);
}
}
