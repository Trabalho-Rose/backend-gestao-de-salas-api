package br.com.cesurgmarau.SistemaRose.core.usecase;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SituacaoSalaRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.SituacaoSalaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.SituacaoSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SituacaoSalaUseCaseImpl implements SituacaoSalaUseCase {

    @Autowired
    //injeção de dependências - nesse caso está injetando o contrato do repositório que possui os métodos (funções)
    //tira a necessidade do acoplamento --> (FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryImpl()
    //tira a necessidade de mexer na regra de negócio (use case) se for trocar o banco ou etc.
    private SituacaoSalaRepository situacaoSalaRepository;
    private SituacaoSala situacaoSala;

    @Override
    public List<SituacaoSala> listar() {
        return situacaoSalaRepository.listar();
    }

    @Override
    public void adicionarSituacaoSala (SituacaoSala situacaoSala) {
        situacaoSalaRepository.adicionarSituacaoSala(situacaoSala);
    }

    @Override
    public String deletarSituacaoSala (int id) {
        return situacaoSalaRepository.deletarSituacaoSala(id);
    }
    @Override
    public SituacaoSala listarid(int id){
        return situacaoSalaRepository.listarid(id);
    }

    @Override
    public String atualizarSituacaoSala (int id, SituacaoSala situacaoSala) {
        return situacaoSalaRepository.atualizarSituacaoSala(id, situacaoSala);
    }
}

