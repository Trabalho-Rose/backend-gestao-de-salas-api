package br.com.cesurgmarau.SistemaRose.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name = "sala")
public class Sala {

    @Id
    @Column (name = "id")
    private int id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "capacidade")
    private int capacidade;

    @Column (name = "situacaoDeSala")
    private int situacaoDeSala;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getSituacaoDeSala() {
        return situacaoDeSala;
    }

    public void getSituacaoDeSala(int situacaoDeSala) {
        this.situacaoDeSala = situacaoDeSala;
    }
}