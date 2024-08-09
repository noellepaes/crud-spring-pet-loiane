package com.noelle.crud_spring_pet_loiane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noelle.crud_spring_pet_loiane.model.Tabela;

@Repository
public interface TabelaRepository extends JpaRepository<Tabela, Long> {

    

    
}
