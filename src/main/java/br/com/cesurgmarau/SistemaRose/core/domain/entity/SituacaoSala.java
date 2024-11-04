package br.com.cesurgmarau.SistemaRose.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name = "situacaoSala")
public class SituacaoSala {

    @Id
    @Column(name = "id")
    private int id;

    @Column (name = "situacaoSala")
    private String situacaoSala;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSituacaoSala() {
        return situacaoSala;
    }

    public void setSituacaoSala(String situacaoSala) {
        this.situacaoSala = situacaoSala;
    }
}
