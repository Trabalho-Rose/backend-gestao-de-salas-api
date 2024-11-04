package br.com.cesurgmarau.SistemaRose.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name = "diasDaSemana")
public class DiasDaSemana {

    @Id
    @Column (name = "id")
    private int id;

    @Column (name = "diaTrabalhado")
    private String diaTrabalhado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiaTrabalhado() {
        return diaTrabalhado;
    }

    public void setDiaTrabalhado(String diaTrabalhado) {
        this.diaTrabalhado = diaTrabalhado;
    }
}
