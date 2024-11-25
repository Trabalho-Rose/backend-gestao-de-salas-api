package br.com.cesurgmarau.SistemaRose.core.domain.entity;

public class ConsultaSorteio {

    private String curso;

    private String sala;

    private String professor;

    private String disciplina;

    private String turma;

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

    public ConsultaSorteio (String curso, String sala, String professor, String disciplina, String turma) {
        this.curso = curso;
        this.sala = sala;
        this.professor = professor;
        this.disciplina = disciplina;
        this.turma = turma;
    }
}
