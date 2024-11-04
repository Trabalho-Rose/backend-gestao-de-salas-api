package br.com.cesurgmarau.SistemaRose.core.usecase;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.DiasDaSemanaRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.DiasDaSemanaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.DiasDaSemana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiasDaSemanaUseCaseImpl implements DiasDaSemanaUseCase {

    @Autowired
    //injeção de dependências - nesse caso está injetando o contrato do repositório que possui os métodos (funções)
    //tira a necessidade do acoplamento --> (FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryImpl()
    //tira a necessidade de mexer na regra de negócio (use case) se for trocar o banco ou etc.
    private DiasDaSemanaRepository diasDaSemanaRepository;
    private DiasDaSemana diasDaSemana;

    @Override
    public List<DiasDaSemana> listar() {
        return diasDaSemanaRepository.listar();
    }

    @Override
    public DiasDaSemana listarPorId (int id) {
        return diasDaSemanaRepository.listarPorId(id);
    }

    @Override
    public void adicionarDiasDaSemana (DiasDaSemana diasDaSemana) {
        diasDaSemanaRepository.adicionarDiasDaSemana(diasDaSemana);
    }

    @Override
    public String deletarDiasDaSemana (int id) {
        return diasDaSemanaRepository.deletarDiasDaSemana(id);
    }

    @Override
    public String atualizarDiasDaSemana (int id, DiasDaSemana diasDaSemana) {
        return diasDaSemanaRepository.atualizarDiasDaSemana(id, diasDaSemana);
    }

}
