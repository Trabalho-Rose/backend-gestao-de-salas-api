package br.com.cesurgmarau.SistemaRose.core.domain.contract;

import br.com.cesurgmarau.SistemaRose.core.domain.entity.DiasDaSemana;

import java.util.List;

public interface DiasDaSemanaRepository {

    public List<DiasDaSemana> listar ();
    public DiasDaSemana listarPorId (int id);
    public void adicionarDiasDaSemana (DiasDaSemana diasDaSemana);
    public String deletarDiasDaSemana (int id);
    public String atualizarDiasDaSemana (int id, DiasDaSemana diasDaSemana);
}
