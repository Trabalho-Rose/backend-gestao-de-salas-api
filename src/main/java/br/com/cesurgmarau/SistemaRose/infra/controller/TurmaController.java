package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.TurmaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TurmaController {
    @Autowired
    private TurmaUseCase turmaUseCase;


    @GetMapping("/turma")
    public List<Turma> listar() {
        return turmaUseCase.listar();
    }

    @PostMapping("/turma")
    public void adicionarturma (@RequestBody Turma turma) {
        turmaUseCase.adicionarturma(turma);
    }

    @DeleteMapping("/turma/{id}")
    //deleta dados, de acordo com o mé
    public String deletarturma (@PathVariable int id) {
        return turmaUseCase.deletarturma(id);
    }

    @PutMapping("/turma/{id}")
    //atualiza dados
    public String atualizarturma (@PathVariable int id, @RequestBody Turma turma) {
        return turmaUseCase.atualizarturma(id, turma);
    }
    @GetMapping("/turma/{id}")
    public Turma listarid(@PathVariable int id){
        return turmaUseCase.listarid(id);
    }
}
