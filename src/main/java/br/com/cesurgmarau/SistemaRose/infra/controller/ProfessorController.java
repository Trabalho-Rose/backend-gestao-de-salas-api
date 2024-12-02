package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.ProfessorUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Curso;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorUseCase professorUseCase;

    // Método GET para listar todos os professores
    @GetMapping("/professor")
    public ResponseEntity<List<Professor>> listar() {
        try {
            List<Professor> professores = professorUseCase.listar();
            if (professores.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content se não houver professores
            }
            return ResponseEntity.ok(professores); // Retorna 200 OK com a lista de professores
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }

    // Método GET para listar um professor por ID
    @GetMapping("/professor/{id}")
    public ResponseEntity<Professor> listarPorId(@PathVariable int id) {
        try {
            Professor professor = professorUseCase.listarPorId(id);
            if (professor == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 Not Found se não encontrar o professor
            }
            return ResponseEntity.ok(professor); // Retorna 200 OK com o professor encontrado
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }

    // Método POST para adicionar um novo professor
    @PostMapping("/professor")
    public ResponseEntity<String> adicionarProfessor(@RequestBody Professor professor) {
        try {
            professorUseCase.adicionarProfessor(professor);
            return ResponseEntity.status(HttpStatus.CREATED).body("Professor adicionado com sucesso."); // Retorna 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar o professor."); // Retorna 500 em caso de erro
        }
    }

    // Método DELETE para deletar um professor por ID
    @DeleteMapping("/professor/{id}")
    public ResponseEntity<String> deletarProfessor(@PathVariable int id) {
        try {
            String resultado = professorUseCase.deletarProfessor(id);
            if ("Professor não encontrado".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado para exclusão."); // Retorna 404 se não encontrar o professor
            }
            return ResponseEntity.status(HttpStatus.OK).body("Professor deletado com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o professor."); // Retorna 500 em caso de erro
        }
    }

    // Método PUT para atualizar um professor por ID
    @PutMapping("/professor/{id}")
    public ResponseEntity<String> atualizarProfessor(@PathVariable int id, @RequestBody Professor professor) {
        try {
            String resultado = professorUseCase.atualizarProfessor(id, professor);
            if ("Professor não encontrado".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado para atualização."); // Retorna 404 se não encontrar o professor
            }
            return ResponseEntity.status(HttpStatus.OK).body("Professor atualizado com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o professor."); // Retorna 500 em caso de erro
        }
    }
}