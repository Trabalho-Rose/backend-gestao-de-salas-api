package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.TurmaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TurmaController {


    @Autowired
    private TurmaUseCase turmaUseCase;

    // Método GET para listar todas as turmas
    @GetMapping("/turma")
    public ResponseEntity<List<Turma>> listar() {
        try {
            List<Turma> turmas = turmaUseCase.listar();
            if (turmas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content se não houver turmas
            }
            return ResponseEntity.ok(turmas); // Retorna 200 OK com a lista de turmas
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }

    // Método POST para adicionar uma nova turma
    @PostMapping("/turma")
    public ResponseEntity<String> adicionarTurma(@RequestBody Turma turma) {
        try {
            turmaUseCase.adicionarturma(turma);
            return ResponseEntity.status(HttpStatus.CREATED).body("Turma adicionada com sucesso."); // Retorna 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar turma."); // Retorna 500 em caso de erro
        }
    }

    // Método DELETE para deletar uma turma por ID
    @DeleteMapping("/turma/{id}")
    public ResponseEntity<String> deletarTurma(@PathVariable int id) {
        try {
            String resultado = turmaUseCase.deletarturma(id);
            if ("Turma não encontrada".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada para exclusão."); // Retorna 404 Not Found
            }
            return ResponseEntity.status(HttpStatus.OK).body("Turma deletada com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar turma."); // Retorna 500 em caso de erro
        }
    }

    // Método PUT para atualizar uma turma por ID
    @PutMapping("/turma/{id}")
    public ResponseEntity<String> atualizarTurma(@PathVariable int id, @RequestBody Turma turma) {
        try {
            String resultado = turmaUseCase.atualizarturma(id, turma);
            if ("Turma não encontrada".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada para atualização."); // Retorna 404 Not Found
            }
            return ResponseEntity.status(HttpStatus.OK).body("Turma atualizada com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar turma."); // Retorna 500 em caso de erro
        }
    }

    // Método GET para listar uma turma por ID
    @GetMapping("/turma/{id}")
    public ResponseEntity<Turma> listarPorId(@PathVariable int id) {
        try {
            Turma turma = turmaUseCase.listarid(id);
            if (turma == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 Not Found se não encontrar a turma
            }
            return ResponseEntity.ok(turma); // Retorna 200 OK com a turma encontrada
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }
}