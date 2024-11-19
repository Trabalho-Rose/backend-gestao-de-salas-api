package br.com.cesurgmarau.SistemaRose.core.usecase;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.DisciplinaRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.DisciplinaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Disciplina;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Professor;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Relatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaUseCaseImpl implements DisciplinaUseCase {

    @Autowired
    private DisciplinaRepository disciplinaRepository;
    private Disciplina disciplina;

    @Override
    public List<Disciplina> listar() {
        return disciplinaRepository.listar();
    }

    @Override
    public Disciplina listarPorId (int id) {
        return disciplinaRepository.listarPorId(id);
    }

    @Override
    public void adicionarDisciplina (Disciplina disciplina) {
        disciplinaRepository.adicionarDisciplina(disciplina);
    }

    @Override
    public String deletarDisciplina (int id) {
        return disciplinaRepository.deletarDisciplina(id);
    }

    @Override
    public String atualizarDisciplina (int id, Disciplina disciplina) {
        return disciplinaRepository.atualizarDisciplina(id, disciplina);
    }

    @Override
    public List<Relatorio> relatorioDiario () {
        return disciplinaRepository.relatorioDiario();
    }


}
