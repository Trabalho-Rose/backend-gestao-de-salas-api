package br.com.cesurgmarau.SistemaRose.core.domain.entity;

public class Relatorio {

    private String curso;

    private String disciplina;

    private String professor;

    private String turma;

    private String sala;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

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

    public Relatorio (String curso, String disciplina, String professor, String turma, String sala) {
        this.curso = curso;
        this.disciplina = disciplina;
        this.professor = professor;
        this.turma = turma;
        this.sala = sala;
    }

}
