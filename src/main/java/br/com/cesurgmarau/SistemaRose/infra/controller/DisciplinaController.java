package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.DisciplinaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Disciplina;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Professor;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Relatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DisciplinaController {

    @Autowired
    private DisciplinaUseCase disciplinaUseCase;

    // Método GET para listar todas as disciplinas
    @GetMapping("/disciplina")
    public ResponseEntity<List<Disciplina>> listar() {
        try {
            List<Disciplina> disciplinas = disciplinaUseCase.listar();
            if (disciplinas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content se não houver disciplinas
            }
            return ResponseEntity.ok(disciplinas); // Retorna 200 OK com a lista de disciplinas
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }

    // Método GET para listar uma disciplina por ID
    @GetMapping("/disciplina/{id}")
    public ResponseEntity<Disciplina> listarPorId(@PathVariable int id) {
        try {
            Disciplina disciplina = disciplinaUseCase.listarPorId(id);
            if (disciplina == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 Not Found se não encontrar a disciplina
            }
            return ResponseEntity.ok(disciplina); // Retorna 200 OK com a disciplina encontrada
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }

    // Método POST para adicionar uma nova disciplina
    @PostMapping("/disciplina")
    public ResponseEntity<String> adicionarDisciplina(@RequestBody Disciplina disciplina) {
        try {
            disciplinaUseCase.adicionarDisciplina(disciplina);
            return ResponseEntity.status(HttpStatus.CREATED).body("Disciplina adicionada com sucesso."); // Retorna 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar a disciplina."); // Retorna 500 em caso de erro
        }
    }

    // Método DELETE para deletar uma disciplina por ID
    @DeleteMapping("/disciplina/{id}")
    public ResponseEntity<String> deletarDisciplina(@PathVariable int id) {
        try {
            String resultado = disciplinaUseCase.deletarDisciplina(id);
            if ("Disciplina não encontrada".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disciplina não encontrada para exclusão."); // Retorna 404 se não encontrar a disciplina
            }
            return ResponseEntity.status(HttpStatus.OK).body("Disciplina deletada com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar a disciplina."); // Retorna 500 em caso de erro
        }
    }

    // Método PUT para atualizar uma disciplina por ID
    @PutMapping("/disciplina/{id}")
    public ResponseEntity<String> atualizarDisciplina(@PathVariable int id, @RequestBody Disciplina disciplina) {
        try {
            String resultado = disciplinaUseCase.atualizarDisciplina(id, disciplina);
            if ("Disciplina não encontrada".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disciplina não encontrada para atualização."); // Retorna 404 se não encontrar a disciplina
            }
            return ResponseEntity.status(HttpStatus.OK).body("Disciplina atualizada com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar a disciplina."); // Retorna 500 em caso de erro
        }
    }

    // Método GET para relatar o relatório diário de disciplinas
    @GetMapping("/relatorio")
    public ResponseEntity<List<Relatorio>> relatorioDiario() {
        try {
            List<Relatorio> relatorio = disciplinaUseCase.relatorioDiario();
            if (relatorio.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content se não houver relatório
            }
            return ResponseEntity.ok(relatorio); // Retorna 200 OK com o relatório
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }
}