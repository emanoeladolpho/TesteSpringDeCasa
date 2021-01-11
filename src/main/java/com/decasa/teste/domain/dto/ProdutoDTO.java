package com.decasa.teste.domain.dto;

public class ProdutoDTO {
    // DECLARAR OS ATRIBUTOS QUE EU QUERO RETORNAR
    // SETAR OS ATRIBUTOS
    // CRIAR O OBJETO PRA SER RETORNADO NA CONSULTA DA API

    private String nome;
    private String descricao;
    private Double precoUnitario;

    public ProdutoDTO(){

    }
    public ProdutoDTO(String nome,String descricao, Double precoUnitario) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
