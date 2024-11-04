package br.com.cesurgmarau.SistemaRose.core.domain.contract;

import br.com.cesurgmarau.SistemaRose.core.domain.entity.Curso;

import java.util.List;

public interface CursoRepository {

    public List<Curso> listar ();
    public Curso listarPorId (int id);
    public void adicionarCurso (Curso curso);
    public String deletarCurso (int id);
    public String atualizarCurso (int id, Curso curso);

}