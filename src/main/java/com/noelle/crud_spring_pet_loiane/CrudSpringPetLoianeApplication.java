package com.noelle.crud_spring_pet_loiane;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.noelle.crud_spring_pet_loiane.repository.TabelaRepository;
import com.noelle.crud_spring_pet_loiane.model.Tabela;
import com.noelle.crud_spring_pet_loiane.enums.Categoria;

@SpringBootApplication
public class CrudSpringPetLoianeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringPetLoianeApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(TabelaRepository tabelaRepository) {
        return args -> {
            tabelaRepository.deleteAll();

            Tabela t = new Tabela();
            t.setNome("Angular com Spring");
            t.setCategoria(Categoria.FRONTEND);

            tabelaRepository.save(t);
        };
    }
}