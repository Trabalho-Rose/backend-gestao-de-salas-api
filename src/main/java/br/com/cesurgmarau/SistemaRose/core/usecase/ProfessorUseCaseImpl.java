package br.com.cesurgmarau.SistemaRose.core.usecase;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.ProfessorRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.ProfessorUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorUseCaseImpl implements ProfessorUseCase {

    @Autowired
    //injeção de dependências - nesse caso está injetando o contrato do repositório que possui os métodos (funções)
    //tira a necessidade do acoplamento --> (FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryImpl()
    //tira a necessidade de mexer na regra de negócio (use case) se for trocar o banco ou etc.
    private ProfessorRepository professorRepository;
    private Professor professor;

    @Override
    public List<Professor> listar() {
        return professorRepository.listar();
    }

    @Override
    public Professor listarPorId (int id) {
        return professorRepository.listarPorId(id);
    }

    @Override
    public void adicionarProfessor (Professor professor) {
        professorRepository.adicionarProfessor(professor);
    }

    @Override
    public String deletarProfessor (int id) {
        return professorRepository.deletarProfessor(id);
    }

    @Override
    public String atualizarProfessor (int id, Professor professor) {
        return professorRepository.atualizarProfessor(id, professor);
    }

}