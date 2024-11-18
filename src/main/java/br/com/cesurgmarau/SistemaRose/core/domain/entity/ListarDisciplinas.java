package br.com.cesurgmarau.SistemaRose.core.domain.entity;

public class ListarDisciplinas {

    private int id;

    private String nomeCurso;

    private String disciplina;

    private int cargaHoraria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ListarDisciplinas (int id, String nomeCurso, String disciplina, int cargaHoraria) {
        this.id = id;
        this.nomeCurso = nomeCurso;
        this.disciplina = disciplina;
        this.cargaHoraria = cargaHoraria;
    }
}