package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SituacaoSalaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.TurmaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.SituacaoSala;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SituacaoSalaController {

    @Autowired
    private SituacaoSalaUseCase situacaoSalaUseCase;


    @GetMapping("/situacaoSala")
    public List<SituacaoSala> listar() {
        return situacaoSalaUseCase.listar();
    }

    @PostMapping("/situacaoSala")
    public void adicionarSituacaoSala (@RequestBody SituacaoSala situacaoSala) {
        situacaoSalaUseCase.adicionarSituacaoSala(situacaoSala);
    }

    @DeleteMapping("/situacaoSala/{id}")
    //deleta dados, de acordo com o mé
    public String deletarSituacaoSala (@PathVariable int id) {
        return situacaoSalaUseCase.deletarSituacaoSala(id);
    }

    @PutMapping("/situacaoSala/{id}")
    //atualiza dados
    public String atualizarSituacaoSala (@PathVariable int id, @RequestBody SituacaoSala situacaoSala) {
        return situacaoSalaUseCase.atualizarSituacaoSala(id, situacaoSala);
    }
    @GetMapping("/situacaoSala/{id}")
    public SituacaoSala listarid(@PathVariable int id){
        return situacaoSalaUseCase.listarid(id);
    }
}