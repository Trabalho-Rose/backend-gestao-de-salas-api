package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.ProfessorUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.SalaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Professor;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Sala;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.VinculoSalasETurmas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaController {

    @Autowired
    private SalaUseCase salaUseCase;

    // Método GET para listar todas as salas
    @GetMapping("/sala")
    public ResponseEntity<List<Sala>> listar() {
        try {
            List<Sala> salas = salaUseCase.listar();
            if (salas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content se não houver salas
            }
            return ResponseEntity.ok(salas); // Retorna 200 OK com a lista de salas
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }

    // Método GET para listar uma sala por ID
    @GetMapping("/sala/{id}")
    public ResponseEntity<Sala> listarPorId(@PathVariable int id) {
        try {
            Sala sala = salaUseCase.listarPorId(id);
            if (sala == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 Not Found se não encontrar a sala
            }
            return ResponseEntity.ok(sala); // Retorna 200 OK com a sala encontrada
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }

    // Método POST para adicionar uma nova sala
    @PostMapping("/sala")
    public ResponseEntity<String> adicionarSala(@RequestBody Sala sala) {
        try {
            salaUseCase.adicionarSala(sala);
            return ResponseEntity.status(HttpStatus.CREATED).body("Sala adicionada com sucesso."); // Retorna 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar a sala."); // Retorna 500 em caso de erro
        }
    }

    // Método DELETE para deletar uma sala por ID
    @DeleteMapping("/sala/{id}")
    public ResponseEntity<String> deletarSala(@PathVariable int id) {
        try {
            String resultado = salaUseCase.deletarSala(id);
            if ("Sala não encontrada".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sala não encontrada para exclusão."); // Retorna 404 se não encontrar a sala
            }
            return ResponseEntity.status(HttpStatus.OK).body("Sala deletada com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar a sala."); // Retorna 500 em caso de erro
        }
    }

    // Método PUT para atualizar uma sala por ID
    @PutMapping("/sala/{id}")
    public ResponseEntity<String> atualizarSala(@PathVariable int id, @RequestBody Sala sala) {
        try {
            String resultado = salaUseCase.atualizarSala(id, sala);
            if ("Sala não encontrada".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sala não encontrada para atualização."); // Retorna 404 se não encontrar a sala
            }
            return ResponseEntity.status(HttpStatus.OK).body("Sala atualizada com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar a sala."); // Retorna 500 em caso de erro
        }
    }

    // Método POST para vincular uma turma a uma sala
    @PostMapping("/sala/{salaID}/turma/{turmaID}")
    public ResponseEntity<String> vincularTurma(@PathVariable int salaID, @PathVariable int turmaID) {
        try {
            String resultado = salaUseCase.vincularTurma(salaID, turmaID);
            if ("Vinculo não encontrado".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vinculo entre sala e turma não encontrado.");
            }
            return ResponseEntity.status(HttpStatus.OK).body("Turma vinculada à sala com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao vincular a turma à sala.");
        }
    }

    // Método PUT para reiniciar a tabela
    @PutMapping("/sala")
    public ResponseEntity<String> reiniciarTabela() {
        try {
            salaUseCase.reiniciarTabela();
            return ResponseEntity.status(HttpStatus.OK).body("Tabela reiniciada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao reiniciar a tabela.");
        }
    }

    // Método GET para listar turmas e salas
    @GetMapping("/sala/turma")
    public ResponseEntity<List<VinculoSalasETurmas>> listarTurmasESalas() {
        try {
            List<VinculoSalasETurmas> vinculos = salaUseCase.listarTurmasESalas();
            if (vinculos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content se não houver vinculos
            }
            return ResponseEntity.ok(vinculos); // Retorna 200 OK com a lista de vinculos
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }
}