package br.com.cesurgmarau.SistemaRose.core.domain.contract;

import br.com.cesurgmarau.SistemaRose.core.domain.entity.SituacaoSala;

import java.util.List;

public interface SituacaoSalaUseCase {
    public SituacaoSala listarid(int id);
    public List<SituacaoSala> listar ();
    public void adicionarSituacaoSala (SituacaoSala situacaoSala);
    public String deletarSituacaoSala (int id);
    public String atualizarSituacaoSala (int id, SituacaoSala situacaoSala);

}
