package br.com.cesurgmarau.SistemaRose.core.domain.entity;

public class VinculoSalasETurmas {

    private String turma;

    private String sala;

    private int id_turma;

    private int id_sala;

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getId_turma() {
        return id_turma;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public VinculoSalasETurmas (int id_turma, String turma, int id_sala, String sala) {
        this.id_turma = id_turma;
        this.turma = turma;
        this.id_sala = id_sala;
        this.sala = sala;
    }
}
