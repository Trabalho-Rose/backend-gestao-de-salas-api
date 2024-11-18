package br.com.cesurgmarau.SistemaRose.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name = "professor")
public class Professor {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "diatrabalhado_id")
    private int diaTrabalhado_id;

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

    public int getDiaTrabalhado_id() {
        return diaTrabalhado_id;
    }

    public void setDiaTrabalhado_id(int diasTrabalhado_id) {
        this.diaTrabalhado_id = diasTrabalhado_id;
    }
}

