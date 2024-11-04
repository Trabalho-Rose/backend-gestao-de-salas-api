package br.com.cesurgmarau.SistemaRose.core.usecase;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.TurmasSalasRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.TurmasSalasUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.SituacaoSala;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.TurmasSalas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmasSalasUseCaseImpl implements TurmasSalasUseCase{

    @Autowired
    TurmasSalasRepository turmasSalasRepository;
    TurmasSalas turmasSalas;

    @Override
    public List<TurmasSalas> listar() {
        return turmasSalasRepository.listar();
    }

    @Override
    public void adicionarTurmasSalas (TurmasSalas turmasSalas) {
        turmasSalasRepository.adicionarTurmasSalas(turmasSalas);
    }

    @Override
    public String deletarTurmasSalas(int id) {
        return turmasSalasRepository.deletarTurmasSalas(id);
    }
    @Override
    public TurmasSalas listarPorId(int id){
        return turmasSalasRepository.listarPorId(id);
    }

    @Override
    public String atualizarTurmasSalas (int id, TurmasSalas turmasSalas) {
        return turmasSalasRepository.atualizarTurmasSalas(id, turmasSalas);
    }


}
