package br.com.guilherme.desafio.repositories;

import br.com.guilherme.desafio.entities.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {

}
