package br.com.guilherme.desafio.dto;

import br.com.guilherme.desafio.entities.Participante;

public class ParticipanteDTO {
    private Integer id;
    private String nome;
    private String email;

    public ParticipanteDTO() {
    }

    public ParticipanteDTO(Participante entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
