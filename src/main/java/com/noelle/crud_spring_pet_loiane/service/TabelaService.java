package com.noelle.crud_spring_pet_loiane.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.noelle.crud_spring_pet_loiane.dto.TabelaDTO;
import com.noelle.crud_spring_pet_loiane.dto.mapper.TabelaMapper;
import com.noelle.crud_spring_pet_loiane.exception.RecordNotFoundExeption;
import com.noelle.crud_spring_pet_loiane.repository.TabelaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class TabelaService {
    
    private final TabelaRepository tabelaRepository;
    private final TabelaMapper tabelaMapper;

    public TabelaService(TabelaRepository tabelaRepository, TabelaMapper tabelaMapper){
        this.tabelaRepository = tabelaRepository;
        this.tabelaMapper = tabelaMapper;
    }

    public List<TabelaDTO> list() {
        return tabelaRepository.findAll()
        .stream()
        .map(tabelaMapper::toDTO)
        .collect(Collectors.toList());
    }

    public TabelaDTO findbyId(@PathVariable @NotNull @Positive Long id) {
        return tabelaRepository.findById(id).map(tabelaMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundExeption(id));
    }

    public TabelaDTO create(@Valid @NotNull TabelaDTO tabela){
        return tabelaMapper.toDTO(tabelaRepository.save(tabelaMapper.toEntity(tabela))) ;
    }

   public TabelaDTO update(@PathVariable Long id, @Valid @NotNull TabelaDTO tabela) {
    try {
        return tabelaRepository.findById(id)
            .map(recordFound -> {
                recordFound.setNome(tabela.nome());
                recordFound.setCategoria(tabela.categoria());
                return tabelaMapper.toDTO(tabelaRepository.save(recordFound));
            })
            .orElseThrow(() -> new RecordNotFoundExeption(id));
    } catch (Exception e) {
        System.err.println("Error during update: " + e.getMessage());
        throw e;
    }
}
   public void delete(@PathVariable @NotNull @Positive Long id) {

    tabelaRepository.delete(tabelaRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundExeption(id)));
   
}
}
