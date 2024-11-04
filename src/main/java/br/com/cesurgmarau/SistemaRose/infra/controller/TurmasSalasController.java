package br.com.cesurgmarau.SistemaRose.infra.controller;


import br.com.cesurgmarau.SistemaRose.core.domain.contract.TurmasSalasUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Turma;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.TurmasSalas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TurmasSalasController {

    @Autowired
    TurmasSalasUseCase turmasSalasUseCase;

    @GetMapping("/turmasSalas")
    public List<TurmasSalas> listar() {
        return turmasSalasUseCase.listar();
    }

    @PostMapping("/turmasSalas")
    public void adicionarTurmasSalas (@RequestBody TurmasSalas turmasSalas) {
        turmasSalasUseCase.adicionarTurmasSalas(turmasSalas);
    }

    @DeleteMapping("/turmasSalas/{id}")
    //deleta dados, de acordo com o mé
    public String deletarTurmasSalas (@PathVariable int id) {
        return turmasSalasUseCase.deletarTurmasSalas(id);
    }

    @PutMapping("/turmasSalas/{id}")
    //atualiza dados
    public String atualizarTurmasSalas (@PathVariable int id, @RequestBody TurmasSalas turmasSalas) {
        return turmasSalasUseCase.atualizarTurmasSalas(id, turmasSalas);
    }
    @GetMapping("/turmasSalas/{id}")
    public TurmasSalas listarid(@PathVariable int id){
        return turmasSalasUseCase.listarPorId(id);
    }


}
