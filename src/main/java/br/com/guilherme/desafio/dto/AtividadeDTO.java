package br.com.guilherme.desafio.dto;

import br.com.guilherme.desafio.entities.Atividade;

public class AtividadeDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer categoriaId;

    public AtividadeDTO(Integer id, String nome, String descricao, Double preco, Integer categoriaId){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoriaId = categoriaId;

    }

    public AtividadeDTO(Atividade entity) {
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
        preco = entity.getPreco();
        categoriaId = entity.getCategoria().getId();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }
}
