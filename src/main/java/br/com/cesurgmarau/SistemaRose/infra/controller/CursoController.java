package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.CursoUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Curso;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Disciplina;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.ListarDisciplinas;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //denomina o local do controller para o meio externo
public class CursoController {
//realiza a comunicação de rotas (protocolo HTTP - conexão com API)
//ponto de entrada de informações pelo navegador ou uma API

    @Autowired
    private CursoUseCase cursoUseCase;

    @GetMapping("/curso")
    public ResponseEntity<List<Curso>> listar() {
        try {
            List<Curso> cursos = cursoUseCase.listar();
            if (cursos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 se não houver cursos
            }
            return ResponseEntity.ok(cursos);
        } catch (NoResultException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Retorna 404 se não encontrar resultados
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Retorna 500 em caso de erro inesperado
        }
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<Curso> listarPorId(@PathVariable int id) {
        try {
            Curso curso = cursoUseCase.listarPorId(id);
            if (curso == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 se não encontrar o curso
            }
            return ResponseEntity.ok(curso);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Retorna 500 em caso de erro inesperado
        }
    }

    @PostMapping("/curso")
    public ResponseEntity<String> adicionarCurso(@RequestBody Curso curso) {
        try {
            cursoUseCase.adicionarCurso(curso);
            return ResponseEntity.status(HttpStatus.CREATED).body("Curso adicionado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao adicionar o curso."); // Retorna 500 em caso de erro inesperado
        }
    }

    @DeleteMapping("/curso/{id}")
    public ResponseEntity<String> deletarCurso(@PathVariable int id) {
        try {
            String resultado = cursoUseCase.deletarCurso(id);
            if (resultado.equals("Curso não encontrado")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado para exclusão.");
            }
            return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar o curso.");
        }
    }

    @PutMapping("/curso/{id}")
    public ResponseEntity<String> atualizarCurso(@PathVariable int id, @RequestBody Curso curso) {
        try {
            String resultado = cursoUseCase.atualizarCurso(id, curso);
            if (resultado.equals("Curso não encontrado")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado para atualização.");
            }
            return ResponseEntity.status(HttpStatus.OK).body("Curso atualizado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar o curso.");
        }
    }

    @PostMapping("/curso/{cursoID}/disciplina/{disciplinaID}")
    public ResponseEntity<String> adicionarDisciplina(@PathVariable int cursoID, @PathVariable int disciplinaID) {
        try {
            cursoUseCase.adicionarDisciplina(cursoID, disciplinaID);
            return ResponseEntity.status(HttpStatus.OK).body("Disciplina adicionada ao curso com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao adicionar a disciplina ao curso.");
        }
    }

    @GetMapping("/curso/{cursoID}/disciplina")
    public ResponseEntity<List<ListarDisciplinas>> listarDisciplinasPorCurso(@PathVariable int cursoID) {
        try {
            List<ListarDisciplinas> disciplinas = cursoUseCase.listarDisciplinasPorCurso(cursoID);
            if (disciplinas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 se não houver disciplinas
            }
            return ResponseEntity.ok(disciplinas);
        } catch (NoResultException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Retorna 404 se não encontrar disciplinas para o curso
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Retorna 500 em caso de erro inesperado
        }
    }
}