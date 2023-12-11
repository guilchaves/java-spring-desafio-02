package br.com.guilherme.desafio.dto;

import br.com.guilherme.desafio.entities.Categoria;


public class CategoriaDTO {
    private Integer id;
    private String descricao;


    public CategoriaDTO(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public CategoriaDTO(Categoria entity) {
        id = entity.getId();
        descricao = entity.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

}
