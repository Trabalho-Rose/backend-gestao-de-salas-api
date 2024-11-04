package br.com.cesurgmarau.SistemaRose.core.domain.contract;

import br.com.cesurgmarau.SistemaRose.core.domain.entity.Sala;

import java.util.List;

public interface SalaRepository {

    public List<Sala> listar ();
    public Sala listarPorId (int id);
    public void adicionarSala (Sala sala);
    public String deletarSala (int id);
    public String atualizarSala (int id, Sala sala);

}