package com.decasa.teste.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lojista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String razaoSocial;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomeFantasia;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String inscricaoEstadual;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String inscricaoMunicipal;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cnpj;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double taxa;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String logomarca;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "lojista")
    @JsonIgnore
    private List<Produto> produtos;

    public Lojista(){

    }

    public Lojista(String nomeFantasia){
        this.nomeFantasia = nomeFantasia;
    }

    public Lojista(Long id, String razaoSocial, String nomeFantasia, String inscricaoEstadual, String inscricaoMunicipal, String cnpj, Double taxa, String logomarca, List<Produto> produtos) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.cnpj = cnpj;
        this.taxa = taxa;
        this.logomarca = logomarca;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public String getLogomarca() {
        return logomarca;
    }

    public void setLogomarca(String logomarca) {
        this.logomarca = logomarca;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
