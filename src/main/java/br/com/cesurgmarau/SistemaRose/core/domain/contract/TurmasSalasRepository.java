package br.com.cesurgmarau.SistemaRose.core.domain.contract;

import br.com.cesurgmarau.SistemaRose.core.domain.entity.TurmasSalas;

import java.util.List;

public interface TurmasSalasRepository {

    public List<TurmasSalas> listar ();
    public TurmasSalas listarPorId (int id);
    public void adicionarTurmasSalas (TurmasSalas turmasSalas);
    public String deletarTurmasSalas (int id);
    public String atualizarTurmasSalas (int id, TurmasSalas turmasSalas);

}