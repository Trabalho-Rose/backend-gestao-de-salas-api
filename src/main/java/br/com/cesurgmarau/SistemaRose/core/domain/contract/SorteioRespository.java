package br.com.cesurgmarau.SistemaRose.core.domain.contract;

import br.com.cesurgmarau.SistemaRose.core.domain.entity.ConsultaSorteio;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Sorteio;

import java.util.List;

public interface SorteioRespository {

    public String adicionarSorteio (Sorteio sorteio);
    public List<ConsultaSorteio> listarSorteios ();
    public ConsultaSorteio listarSorteioPorId (int id);
    public String atualizarSorteio (int id, Sorteio sorteio);
    public String deletarSorteios ();
    public String deletarSorteioPorId (int id);

}