package br.com.cesurgmarau.SistemaRose.core.domain.contract;

import br.com.cesurgmarau.SistemaRose.core.domain.entity.Curso;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Disciplina;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.ListarDisciplinas;

import java.util.List;

public interface CursoRepository {

    public List<Curso> listar ();
    public Curso listarPorId (int id);
    public void adicionarCurso (Curso curso);
    public String deletarCurso (int id);
    public String atualizarCurso (int id, Curso curso);

    public void adicionarDisciplina (int cursoID, int disciplinaID);
    public List<ListarDisciplinas> listarDisciplinasPorCurso (int cursoID);

}