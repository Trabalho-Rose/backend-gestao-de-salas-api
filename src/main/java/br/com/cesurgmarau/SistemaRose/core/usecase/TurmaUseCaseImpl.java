package br.com.cesurgmarau.SistemaRose.core.usecase;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.TurmaRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.TurmaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaUseCaseImpl implements TurmaUseCase {

    @Autowired
    //injeção de dependências - nesse caso está injetando o contrato do repositório que possui os métodos (funções)
    //tira a necessidade do acoplamento --> (FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryImpl()
    //tira a necessidade de mexer na regra de negócio (use case) se for trocar o banco ou etc.
    private TurmaRepository turmaRepository;
    private Turma turma;

    @Override
    public List<Turma> listar() {
        return turmaRepository.listar();
    }

    @Override
    public void adicionarturma (Turma turma) {
        turmaRepository.adicionarturma(turma);
    }

    @Override
    public String deletarturma (int id) {
        return turmaRepository.deletarturma(id);
    }
    @Override
    public Turma listarid(int id){
        return turmaRepository.listarid(id);
    }

    @Override
    public String atualizarturma (int id, Turma turma) {
        return turmaRepository.atualizarturma(id, turma);
    }
}
