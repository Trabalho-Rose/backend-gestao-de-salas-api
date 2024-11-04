package br.com.cesurgmarau.SistemaRose.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name = "curso_disciplina")
public class CursoDisciplina {

    @Id
    @Column (name = "id")
    private int id;

    @Column (name = "curso_id")
    private int curso_id;

    @Column (name = "disciplina_id")
    private int disciplina_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getDisciplina_id() {
        return disciplina_id;
    }

    public void setDisciplina_id(int disciplina_id) {
        this.disciplina_id = disciplina_id;
    }
}
