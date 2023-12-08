package br.com.guilherme.desafio.services;

import br.com.guilherme.desafio.dto.ParticipanteDTO;
import br.com.guilherme.desafio.entities.Participante;
import br.com.guilherme.desafio.repositories.ParticipanteRepository;
import br.com.guilherme.desafio.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository repository;

    @Transactional(readOnly = true)
    public Page<ParticipanteDTO> findAll(Pageable pageable) {
        Page<Participante> result = repository.findAll(pageable);
        return result.map(ParticipanteDTO::new);
    }

    @Transactional(readOnly = true)
    public ParticipanteDTO findById(Integer id) {
        Participante entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found")
        );
        return new ParticipanteDTO(entity);
    }

    @Transactional
    public ParticipanteDTO insert(@RequestBody ParticipanteDTO dto) {
        Participante entity = new Participante();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ParticipanteDTO(entity);
    }

    @Transactional
    public ParticipanteDTO update(Integer id, ParticipanteDTO dto) {
        try {
            Participante entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ParticipanteDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Resource not found");
        }

    }

    private void copyDtoToEntity(ParticipanteDTO dto, Participante entity) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
    }
}
