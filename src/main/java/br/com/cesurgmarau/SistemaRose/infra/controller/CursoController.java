package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.CursoUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Curso;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Disciplina;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.ListarDisciplinas;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //denomina o local do controller para o meio externo
public class CursoController {
//realiza a comunicação de rotas (protocolo HTTP - conexão com API)
//ponto de entrada de informações pelo navegador ou uma API

    @Autowired
    private CursoUseCase cursoUseCase;


    @GetMapping("/curso")
    //puxa os dados do local (nesse caso /funcionario e realiza o método, mostrando na tela)
    public List<Curso> listar() {
        try {
            return cursoUseCase.listar();
        } catch (NoResultException e) {
           return null;
        }
    }

    @GetMapping("/curso/{id}")
    public Curso listarPorId (@PathVariable int id) {
        return cursoUseCase.listarPorId(id);
    }

    @PostMapping("/curso")
    //posta e injeta dados, de acordo com o método
    public void adicionarCurso (@RequestBody Curso curso) {
        cursoUseCase.adicionarCurso(curso);
    }

    @DeleteMapping("/curso/{id}")
    //deleta dados, de acordo com o método
    public String deletarCurso (@PathVariable int id) {
        return cursoUseCase.deletarCurso(id);
    }

    @PutMapping("/curso/{id}")
    //atualiza dados
    public String atualizarCurso (@PathVariable int id, @RequestBody Curso curso) {
        return cursoUseCase.atualizarCurso(id, curso);
    }

    @PostMapping ("/curso/{cursoID}/disciplina/{disciplinaID}")
    public void adicionarDisciplina (@PathVariable int cursoID, @PathVariable int disciplinaID) {
        cursoUseCase.adicionarDisciplina(cursoID, disciplinaID);
    }

    @GetMapping ("/curso/{cursoID}/disciplina")
    public List<ListarDisciplinas> listarDisciplinasPorCurso (@PathVariable int cursoID) {
        return cursoUseCase.listarDisciplinasPorCurso(cursoID);
    }


}