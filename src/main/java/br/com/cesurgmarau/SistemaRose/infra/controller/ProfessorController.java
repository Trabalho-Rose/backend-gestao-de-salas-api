package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.ProfessorUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Curso;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorUseCase professorUseCase;


    @GetMapping("/professor")
    //puxa os dados do local (nesse caso /funcionario e realiza o método, mostrando na tela)
    public List<Professor> listar() {
        return professorUseCase.listar();
    }

    @GetMapping("/professor/{id}")
    public Professor listarPorId (@PathVariable int id) {
        return professorUseCase.listarPorId(id);
    }

    @PostMapping("/professor")
    //posta e injeta dados, de acordo com o método
    public void adicionarProfessor (@RequestBody Professor professor) {
        professorUseCase.adicionarProfessor(professor);
    }

    @DeleteMapping("/professor/{id}")
    //deleta dados, de acordo com o método
    public String deletarProfessor (@PathVariable int id) {
        return professorUseCase.deletarProfessor(id);
    }

    @PutMapping("/professor/{id}")
    //atualiza dados
    public String atualizarProfessor (@PathVariable int id, @RequestBody Professor professor) {
        return professorUseCase.atualizarProfessor(id, professor);
    }
}