package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SituacaoSalaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.TurmaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.SituacaoSala;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SituacaoSalaController {

    @Autowired
    private SituacaoSalaUseCase situacaoSalaUseCase;

    // Método GET para listar todas as situações das salas
    @GetMapping("/situacaoSala")
    public ResponseEntity<List<SituacaoSala>> listar() {
        try {
            List<SituacaoSala> situacoes = situacaoSalaUseCase.listar();
            if (situacoes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content se não houver situações
            }
            return ResponseEntity.ok(situacoes); // Retorna 200 OK com a lista de situações
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }

    // Método POST para adicionar uma nova situação de sala
    @PostMapping("/situacaoSala")
    public ResponseEntity<String> adicionarSituacaoSala(@RequestBody SituacaoSala situacaoSala) {
        try {
            situacaoSalaUseCase.adicionarSituacaoSala(situacaoSala);
            return ResponseEntity.status(HttpStatus.CREATED).body("Situação da sala adicionada com sucesso."); // Retorna 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar situação da sala."); // Retorna 500 em caso de erro
        }
    }

    // Método DELETE para deletar uma situação de sala por ID
    @DeleteMapping("/situacaoSala/{id}")
    public ResponseEntity<String> deletarSituacaoSala(@PathVariable int id) {
        try {
            String resultado = situacaoSalaUseCase.deletarSituacaoSala(id);
            if ("Situação não encontrada".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Situação da sala não encontrada para exclusão."); // Retorna 404 se não encontrar a situação
            }
            return ResponseEntity.status(HttpStatus.OK).body("Situação da sala deletada com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar situação da sala."); // Retorna 500 em caso de erro
        }
    }

    // Método PUT para atualizar uma situação de sala por ID
    @PutMapping("/situacaoSala/{id}")
    public ResponseEntity<String> atualizarSituacaoSala(@PathVariable int id, @RequestBody SituacaoSala situacaoSala) {
        try {
            String resultado = situacaoSalaUseCase.atualizarSituacaoSala(id, situacaoSala);
            if ("Situação não encontrada".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Situação da sala não encontrada para atualização."); // Retorna 404 se não encontrar a situação
            }
            return ResponseEntity.status(HttpStatus.OK).body("Situação da sala atualizada com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar situação da sala."); // Retorna 500 em caso de erro
        }
    }

    // Método GET para listar uma situação de sala por ID
    @GetMapping("/situacaoSala/{id}")
    public ResponseEntity<SituacaoSala> listarid(@PathVariable int id) {
        try {
            SituacaoSala situacaoSala = situacaoSalaUseCase.listarid(id);
            if (situacaoSala == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 Not Found se não encontrar a situação
            }
            return ResponseEntity.ok(situacaoSala); // Retorna 200 OK com a situação encontrada
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }
}