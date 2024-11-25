package br.com.cesurgmarau.SistemaRose.core.usecase;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SorteioRespository;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.SorteioUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.ConsultaSorteio;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Sorteio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SorteioUseCaseImpl implements SorteioUseCase {

   @Autowired
   private SorteioRespository sorteioRespository;
   private Sorteio sorteio;

   @Override
    public void adicionarSorteio (Sorteio sorteio) {
        sorteioRespository.adicionarSorteio(sorteio);
    }

    @Override
    public List<ConsultaSorteio> listarSorteios () {
       return sorteioRespository.listarSorteios();
    }

    @Override
    public Sorteio listarSorteioPorId (int id) {
       return sorteioRespository.listarSorteioPorId(id);
    }

    @Override
    public String atualizarSorteio (int id, Sorteio sorteio) {
       return sorteioRespository.atualizarSorteio(id, sorteio);
    }

    @Override
    public String deletarSorteios () {
       return sorteioRespository.deletarSorteios();
    }

    @Override
    public String deletarSorteioPorId (int id) {
       return sorteioRespository.deletarSorteioPorId(id);
    }
}