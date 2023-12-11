package br.com.guilherme.desafio.dto;

import br.com.guilherme.desafio.entities.Atividade;

public class AtividadeCategoriaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;

    private CategoriaDTO categoria;

    public AtividadeCategoriaDTO(Integer id, String nome, String descricao, Double preco,  CategoriaDTO categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public AtividadeCategoriaDTO(Atividade entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
        this.preco = entity.getPreco();
        this.categoria = new CategoriaDTO(entity.getCategoria());
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

    public CategoriaDTO getCategoria() {
        return categoria;
    }
}
