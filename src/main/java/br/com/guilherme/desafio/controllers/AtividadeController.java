package br.com.guilherme.desafio.controllers;

import br.com.guilherme.desafio.dto.AtividadeCategoriaDTO;
import br.com.guilherme.desafio.dto.AtividadeDTO;
import br.com.guilherme.desafio.services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService service;

    @PostMapping
    public ResponseEntity<AtividadeCategoriaDTO> insert(@RequestBody AtividadeCategoriaDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //@PostMapping
    public ResponseEntity<AtividadeDTO> insert(@RequestBody AtividadeDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}