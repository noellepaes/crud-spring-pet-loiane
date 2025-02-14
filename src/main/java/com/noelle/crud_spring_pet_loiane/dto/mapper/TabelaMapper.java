package com.noelle.crud_spring_pet_loiane.dto.mapper;

import org.springframework.stereotype.Component;

import com.noelle.crud_spring_pet_loiane.dto.TabelaDTO;
import com.noelle.crud_spring_pet_loiane.enums.Categoria;
import com.noelle.crud_spring_pet_loiane.model.Tabela;

@Component
public class TabelaMapper {
    
    public TabelaDTO toDTO(Tabela tabela){
        if(tabela == null){
            return null;
        }
        return new TabelaDTO(tabela.getId(), tabela.getNome(), "Front-end");
    }

   

    public Tabela toEntity(TabelaDTO tabelaDTO) {
        if (tabelaDTO == null) {
            return null;
        }
        
        Tabela tabela = new Tabela();
        if (tabelaDTO.id() != null) {
            tabela.setId(tabelaDTO.id());
        }
        tabela.setNome(tabelaDTO.nome());
        tabela.setCategoria(Categoria.FRONTEND);
        tabela.setStatus("Ativo");
        return tabela;
    }
}
