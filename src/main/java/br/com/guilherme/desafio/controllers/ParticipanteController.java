package br.com.guilherme.desafio.controllers;

import br.com.guilherme.desafio.dto.ParticipanteDTO;
import br.com.guilherme.desafio.services.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService service;

    @GetMapping
    public ResponseEntity<Page<ParticipanteDTO>> findAll(Pageable pageable){
        Page<ParticipanteDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }
}

