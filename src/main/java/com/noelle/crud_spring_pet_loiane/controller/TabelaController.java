package com.noelle.crud_spring_pet_loiane.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.noelle.crud_spring_pet_loiane.dto.TabelaDTO;
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
    public @ResponseBody List<TabelaDTO> list() {
        return tabelaService.list();
    }

    @GetMapping("/{id}")
    public TabelaDTO findbyId(@PathVariable @NotNull @Positive Long id) {
        return tabelaService.findbyId(id);
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public TabelaDTO create(@RequestBody @Valid @NotNull TabelaDTO tabela){
        // System.out.println(tabela.getNome());
        return tabelaService.create(tabela);
        // return ResponseEntity.status(HttpStatus.CREATED)
        //     .body(tabelaRepository.save(tabela));
    }


    @PutMapping("/{id}")
    public TabelaDTO update(@PathVariable @NotNull @Positive Long id,
     @RequestBody @Valid @NotNull TabelaDTO tabela) {
        return tabelaService.update(id, tabela);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
       tabelaService.delete(id);
      
    }
}
