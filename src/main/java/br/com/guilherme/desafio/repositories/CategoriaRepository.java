package br.com.guilherme.desafio.repositories;

import br.com.guilherme.desafio.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
