package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.CursoDisciplinaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.CursoDisciplina;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.SituacaoSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CursoDisciplinaController {

    @Autowired
    CursoDisciplinaUseCase cursoDisciplinaUseCase;

    @GetMapping("/cursoDisciplina")
    public List<CursoDisciplina> listar() {
        return cursoDisciplinaUseCase.listar();
    }

    @PostMapping("/cursoDisciplina")
    public void adicionarCursoDisciplina (@RequestBody CursoDisciplina cursoDisciplina) {
        cursoDisciplinaUseCase.adicionarCursoDisciplina(cursoDisciplina);
    }

    @DeleteMapping("/cursoDisciplina/{id}")
    //deleta dados, de acordo com o mé
    public String deletarCursoDisciplina (@PathVariable int id) {
        return cursoDisciplinaUseCase.deletarCursoDisciplina(id);
    }

    @PutMapping("/cursoDisciplina/{id}")
    //atualiza dados
    public String atualizarCursoDisciplina (@PathVariable int id, @RequestBody CursoDisciplina cursoDisciplina) {
        return cursoDisciplinaUseCase.atualizarCursoDisciplina(id, cursoDisciplina);
    }
    @GetMapping("/cursoDisciplina/{id}")
    public CursoDisciplina listarid(@PathVariable int id){
        return cursoDisciplinaUseCase.listarPorId(id);
    }

}
