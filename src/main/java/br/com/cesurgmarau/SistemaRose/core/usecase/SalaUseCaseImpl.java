package br.com.cesurgmarau.SistemaRose.core.usecase;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SalaRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.SalaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Sala;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.VinculoSalasETurmas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaUseCaseImpl implements SalaUseCase {

    @Autowired
    private SalaRepository salaRepository;
    private Sala sala;

    @Override
    public List<Sala> listar() {
        return salaRepository.listar();
    }

    @Override
    public Sala listarPorId (int id) {
        return salaRepository.listarPorId(id);
    }

    @Override
    public String adicionarSala (Sala sala) {
        return salaRepository.adicionarSala(sala);
    }

    @Override
    public String deletarSala (int id) {
        return salaRepository.deletarSala(id);
    }

    @Override
    public String atualizarSala (int id, Sala sala) {
        return salaRepository.atualizarSala(id, sala);
    }

    @Override
    public String vincularTurma (int salaID, int turmaID) {
        return salaRepository.vincularTurma(salaID, turmaID);
    }

    @Override
    public void reiniciarTabela () {
        salaRepository.reiniciarTabela();
    }

    @Override
    public List<VinculoSalasETurmas> listarTurmasESalas () {
        return salaRepository.listarTurmasESalas();
    }


}