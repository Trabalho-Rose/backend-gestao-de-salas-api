package br.com.cesurgmarau.SistemaRose.core.usecase;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SemestreRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.SemestreUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Semestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemestreUseCaseImpl implements SemestreUseCase {

    @Autowired
    //injeção de dependências - nesse caso está injetando o contrato do repositório que possui os métodos (funções)
    //tira a necessidade do acoplamento --> (FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryImpl()
    //tira a necessidade de mexer na regra de negócio (use case) se for trocar o banco ou etc.
    private SemestreRepository semestreRepository;
    private Semestre semestre;

    @Override
    public List<Semestre> listar() {
        return semestreRepository.listar();
    }

    @Override
    public void adicionarSemestre (Semestre semestre) {
        semestreRepository.adicionarSemestre(semestre);
    }

    @Override
    public String deletarSemestre (int id) {
        return semestreRepository.deletarSemestre(id);
    }
    @Override
    public Semestre listarid(int id){
        return semestreRepository.listarid(id);
    }

    @Override
    public String atualizarSemestre (int id, Semestre semestre) {
        return semestreRepository.atualizarSemestre(id, semestre);
    }
}