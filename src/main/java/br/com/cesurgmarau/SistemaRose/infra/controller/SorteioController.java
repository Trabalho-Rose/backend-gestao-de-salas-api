package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SorteioUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.ConsultaSorteio;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Sorteio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SorteioController {

    @Autowired
    SorteioUseCase sorteioUseCase;

    @PostMapping ("/sorteio")
    public void adicionarSorteio (@RequestBody Sorteio sorteio) {
        sorteioUseCase.adicionarSorteio(sorteio);
    }

    @GetMapping ("/sorteio")
    public List<ConsultaSorteio> listarSorteios () {
        return sorteioUseCase.listarSorteios();
    }

    @GetMapping ("/sorteio/{id}")
    public Sorteio listarSorteioPorId (@PathVariable int id) {
        return sorteioUseCase.listarSorteioPorId(id);
    }

    @PutMapping ("/sorteio/{id}")
    public String atualizarSorteio (@PathVariable int id, @RequestBody Sorteio sorteio) {
        return sorteioUseCase.atualizarSorteio(id, sorteio);
    }

    @DeleteMapping ("/sorteio")
    public String deletarSorteios () {
        return sorteioUseCase.deletarSorteios();
    }

    @DeleteMapping ("/sorteio/{id}")
    public String deletarSorteioPorId (@PathVariable int id) {
        return sorteioUseCase.deletarSorteioPorId(id);
    }
}