package br.com.guilherme.desafio.services;

import br.com.guilherme.desafio.dto.ParticipanteDTO;
import br.com.guilherme.desafio.entities.Participante;
import br.com.guilherme.desafio.repositories.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository repository;

    @Transactional(readOnly = true)
    public Page<ParticipanteDTO> findAll(Pageable pageable) {
        Page<Participante> result = repository.findAll(pageable);
        return result.map(ParticipanteDTO::new);
    }
}
