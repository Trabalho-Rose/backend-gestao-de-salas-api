package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.ProfessorUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.SalaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Professor;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Sala;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.VinculoSalasETurmas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaController {

    @Autowired
    private SalaUseCase salaUseCase;


    @GetMapping("/sala")
    //puxa os dados do local (nesse caso /funcionario e realiza o método, mostrando na tela)
    public List<Sala> listar() {
        return salaUseCase.listar();
    }

    @GetMapping("/sala/{id}")
    public Sala listarPorId (@PathVariable int id) {
        return salaUseCase.listarPorId(id);
    }

    @PostMapping("/sala")
    //posta e injeta dados, de acordo com o método
    public void adicionarSala (@RequestBody Sala sala) {
        salaUseCase.adicionarSala(sala);
    }

    @DeleteMapping("/sala/{id}")
    //deleta dados, de acordo com o método
    public String deletarSala (@PathVariable int id) {
        return salaUseCase.deletarSala(id);
    }

    @PutMapping("/sala/{id}")
    //atualiza dados
    public String atualizarSala (@PathVariable int id, @RequestBody Sala sala) {
        return salaUseCase.atualizarSala(id, sala);
    }

    @PostMapping ("/sala/{salaID}/turma/{turmaID}")
    public String vincularTurma (@PathVariable int salaID, @PathVariable int turmaID) {
        return salaUseCase.vincularTurma(salaID, turmaID);
    }

    @PutMapping ("/sala")
    public void reiniciarTabela () {
        salaUseCase.reiniciarTabela();
    }

    @GetMapping ("/sala/turma")
    public List<VinculoSalasETurmas> listarTurmasESalas () {
        return salaUseCase.listarTurmasESalas();
    }

}
