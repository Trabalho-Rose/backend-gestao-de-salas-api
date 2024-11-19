package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.DisciplinaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Disciplina;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Professor;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Relatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DisciplinaController {

    @Autowired
    private DisciplinaUseCase disciplinaUseCase;


    @GetMapping("/disciplina")
    //puxa os dados do local (nesse caso /funcionario e realiza o método, mostrando na tela)
    public List<Disciplina> listar() {
        return disciplinaUseCase.listar();
    }

    @GetMapping("/disciplina/{id}")
    public Disciplina listarPorId (@PathVariable int id) {
        return disciplinaUseCase.listarPorId(id);
    }

    @PostMapping("/disciplina")
    //posta e injeta dados, de acordo com o método
    public void adicionarDisciplina (@RequestBody Disciplina disciplina) {
        disciplinaUseCase.adicionarDisciplina(disciplina);
    }

    @DeleteMapping("/disciplina/{id}")
    //deleta dados, de acordo com o método
    public String deletarDisciplina (@PathVariable int id) {
        return disciplinaUseCase.deletarDisciplina(id);
    }

    @PutMapping("/disciplina/{id}")
    //atualiza dados
    public String atualizarDisciplina (@PathVariable int id, @RequestBody Disciplina disciplina) {
        return disciplinaUseCase.atualizarDisciplina(id, disciplina);
    }

    @GetMapping ("/relatorio")
    public List<Relatorio> relatorioDiario () {
        return disciplinaUseCase.relatorioDiario();
    }

}
