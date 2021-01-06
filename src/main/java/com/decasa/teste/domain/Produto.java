package com.decasa.teste.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String descricao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String marcaFabricante;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String unidadeMedida;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double pontuacao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cor;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String foto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String video;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double precoUnitario;

    public Produto(){

    }

    public Produto(Long id, String nome, String descricao, String marcaFabricante, String unidadeMedida, Double pontuacao, String cor, String foto, String video, Double precoUnitario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.marcaFabricante = marcaFabricante;
        this.unidadeMedida = unidadeMedida;
        this.pontuacao = pontuacao;
        this.cor = cor;
        this.foto = foto;
        this.video = video;
        this.precoUnitario = precoUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMarcaFabricante() {
        return marcaFabricante;
    }

    public void setMarcaFabricante(String marcaFabricante) {
        this.marcaFabricante = marcaFabricante;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}