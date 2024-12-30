package com.example.shopper_uber.entities;

import jakarta.persistence.*;

@Entity(name="driver")
@Table(name="drivers")
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    private String descricao;

    private String carro;

    private String avaliacao;

    private int taxa_km;

    private int km_minimo;

    @Transient
    private Integer valor;

    public DriverEntity() {
    }

    public DriverEntity(Integer id, String nome, String descricao, String carro, String avaliacao, int taxa_km, int km_minimo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.carro = carro;
        this.avaliacao = avaliacao;
        this.taxa_km = taxa_km;
        this.km_minimo = km_minimo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getTaxa_km() {
        return taxa_km;
    }

    public void setTaxa_km(int taxa_km) {
        this.taxa_km = taxa_km;
    }

    public int getKm_minimo() {
        return km_minimo;
    }

    public void setKm_minimo(int km_minimo) {
        this.km_minimo = km_minimo;
    }
}
