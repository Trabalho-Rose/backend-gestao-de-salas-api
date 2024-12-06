package br.com.cesurgmarau.SistemaRose.core.domain.entity;

public class ConsultaSorteio {

    private int id_sorteio;

    private String curso;

    private String sala;

    private String professor;

    private String disciplina;

    private String turma;

    public int getId_Sorteio() {
        return id_sorteio;
    }

    public void setId_Sorteio(int id_sorteio) {
        this.id_sorteio = id_sorteio;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public ConsultaSorteio (int id_sorteio, String curso, String sala, String professor, String disciplina, String turma) {
        this.id_sorteio = id_sorteio;
        this.curso = curso;
        this.sala = sala;
        this.professor = professor;
        this.disciplina = disciplina;
        this.turma = turma;
    }
}
