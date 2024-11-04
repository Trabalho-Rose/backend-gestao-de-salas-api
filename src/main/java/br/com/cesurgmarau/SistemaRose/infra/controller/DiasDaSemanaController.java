package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.DiasDaSemanaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.DiasDaSemana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiasDaSemanaController {

    @Autowired
    private DiasDaSemanaUseCase diasDaSemanaUseCase;


    @GetMapping("/diasDaSemana")
    //puxa os dados do local (nesse caso /funcionario e realiza o método, mostrando na tela)
    public List<DiasDaSemana> listar() {
        return diasDaSemanaUseCase.listar();
    }

    @GetMapping("/diasDaSemana/{id}")
    public DiasDaSemana listarPorId (@PathVariable int id) {
        return diasDaSemanaUseCase.listarPorId(id);
    }

    @PostMapping("/diasDaSemana")
    //posta e injeta dados, de acordo com o método
    public void adicionarDiasDaSemana (@RequestBody DiasDaSemana diasDaSemana) {
        diasDaSemanaUseCase.adicionarDiasDaSemana(diasDaSemana);
    }

    @DeleteMapping("/diasDaSemana/{id}")
    //deleta dados, de acordo com o método
    public String deletarDiasDaSemana (@PathVariable int id) {
        return diasDaSemanaUseCase.deletarDiasDaSemana(id);
    }

    @PutMapping("/diasDaSemana/{id}")
    //atualiza dados
    public String atualizarDiasDaSemana (@PathVariable int id, @RequestBody DiasDaSemana diasDaSemana) {
        return diasDaSemanaUseCase.atualizarDiasDaSemana(id, diasDaSemana);
    }

}