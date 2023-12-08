package br.com.guilherme.desafio.controllers;

import br.com.guilherme.desafio.dto.ParticipanteDTO;
import br.com.guilherme.desafio.services.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService service;

    @GetMapping
    public ResponseEntity<Page<ParticipanteDTO>> findAll(Pageable pageable) {
        Page<ParticipanteDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParticipanteDTO> findById(@PathVariable Integer id) {
        ParticipanteDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ParticipanteDTO> insert(@RequestBody ParticipanteDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ParticipanteDTO> update(@PathVariable Integer id, @RequestBody ParticipanteDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }
}

