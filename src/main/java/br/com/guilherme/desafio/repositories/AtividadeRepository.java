package br.com.guilherme.desafio.repositories;

import br.com.guilherme.desafio.entities.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {
}
