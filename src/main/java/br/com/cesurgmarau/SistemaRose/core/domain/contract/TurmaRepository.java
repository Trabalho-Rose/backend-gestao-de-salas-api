package br.com.cesurgmarau.SistemaRose.core.domain.contract;

import br.com.cesurgmarau.SistemaRose.core.domain.entity.Turma;

import java.util.List;

public interface TurmaRepository {
    public Turma listarid(int id);
    public List<Turma> listar ();
    public void adicionarturma (Turma turma);
    public String deletarturma (int id);
    public String atualizarturma (int id, Turma turma);

}
