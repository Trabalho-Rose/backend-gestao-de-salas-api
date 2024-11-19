package br.com.cesurgmarau.SistemaRose.core.domain.contract;

import br.com.cesurgmarau.SistemaRose.core.domain.entity.Disciplina;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Professor;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Relatorio;

import java.util.List;

public interface DisciplinaRepository {

    public List<Disciplina> listar ();
    public Disciplina listarPorId (int id);
    public void adicionarDisciplina (Disciplina disciplina);
    public String deletarDisciplina (int id);
    public String atualizarDisciplina (int id, Disciplina disciplina);

    public List<Relatorio> relatorioDiario ();
}
