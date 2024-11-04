package br.com.cesurgmarau.SistemaRose.core.usecase;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.CursoDisciplinaRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.CursoDisciplinaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.CursoDisciplina;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoDisciplinaUseCaseImpl implements CursoDisciplinaUseCase {

    @Autowired
    CursoDisciplinaRepository cursoDisciplinaRepository;
    CursoDisciplina cursoDisciplina;

    @Override
    public List<CursoDisciplina> listar() {
        return cursoDisciplinaRepository.listar();
    }

    @Override
    public CursoDisciplina listarPorId (int id) {
        return cursoDisciplinaRepository.listarPorId(id);
    }

    @Override
    public void adicionarCursoDisciplina (CursoDisciplina cursoDisciplina) {
        cursoDisciplinaRepository.adicionarCursoDisciplina(cursoDisciplina);
    }

    @Override
    public String deletarCursoDisciplina (int id) {
        return cursoDisciplinaRepository.deletarCursoDisciplina(id);
    }

    @Override
    public String atualizarCursoDisciplina (int id, CursoDisciplina cursoDisciplina) {
        return cursoDisciplinaRepository.atualizarCursoDisciplina (id, cursoDisciplina);
    }

}
