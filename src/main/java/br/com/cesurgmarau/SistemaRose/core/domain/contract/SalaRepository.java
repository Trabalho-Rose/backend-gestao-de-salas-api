package br.com.cesurgmarau.SistemaRose.core.domain.contract;

import br.com.cesurgmarau.SistemaRose.core.domain.entity.Sala;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.VinculoSalasETurmas;

import java.util.List;

public interface SalaRepository {

    public List<Sala> listar ();
    public Sala listarPorId (int id);
    public void adicionarSala (Sala sala);
    public String deletarSala (int id);
    public String atualizarSala (int id, Sala sala);

    public String vincularTurma (int salaID, int turmaID);
    public List<VinculoSalasETurmas> listarTurmasESalas ();
    public void reiniciarTabela ();

}