package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SemestreUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Semestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SemestreController {

    @Autowired
    private SemestreUseCase semestreUseCase;


    @GetMapping("/semestre")
    public List<Semestre> listar() {
        return semestreUseCase.listar();
    }

    @PostMapping("/semestre")
    public void adicionarSemestre (@RequestBody Semestre semestre) {
        semestreUseCase.adicionarSemestre(semestre);
    }

    @DeleteMapping("/semestre/{id}")
    //deleta dados, de acordo com o mé
    public String deletarSemestre (@PathVariable int id) {
        return semestreUseCase.deletarSemestre(id);
    }

    @PutMapping("/semestre/{id}")
    //atualiza dados
    public String atualizarturma (@PathVariable int id, @RequestBody Semestre semestre) {
        return semestreUseCase.atualizarSemestre(id, semestre);
    }
    @GetMapping("/semestre/{id}")
    public Semestre listarid(@PathVariable int id){
        return semestreUseCase.listarid(id);
    }
}