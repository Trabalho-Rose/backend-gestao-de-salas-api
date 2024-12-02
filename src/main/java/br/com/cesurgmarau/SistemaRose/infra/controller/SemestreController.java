package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SemestreUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Semestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SemestreController {

    @Autowired
    private SemestreUseCase semestreUseCase;

    // Método GET para listar todos os semestres
    @GetMapping("/semestre")
    public ResponseEntity<List<Semestre>> listar() {
        try {
            List<Semestre> semestres = semestreUseCase.listar();
            if (semestres.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content se não houver semestres
            }
            return ResponseEntity.ok(semestres); // Retorna 200 OK com a lista de semestres
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }

    // Método POST para adicionar um novo semestre
    @PostMapping("/semestre")
    public ResponseEntity<String> adicionarSemestre(@RequestBody Semestre semestre) {
        try {
            semestreUseCase.adicionarSemestre(semestre);
            return ResponseEntity.status(HttpStatus.CREATED).body("Semestre adicionado com sucesso."); // Retorna 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar semestre."); // Retorna 500 em caso de erro
        }
    }

    // Método DELETE para deletar um semestre por ID
    @DeleteMapping("/semestre/{id}")
    public ResponseEntity<String> deletarSemestre(@PathVariable int id) {
        try {
            String resultado = semestreUseCase.deletarSemestre(id);
            if ("Semestre não encontrado".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Semestre não encontrado para exclusão."); // Retorna 404 se não encontrar o semestre
            }
            return ResponseEntity.status(HttpStatus.OK).body("Semestre deletado com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar semestre."); // Retorna 500 em caso de erro
        }
    }

    // Método PUT para atualizar um semestre por ID
    @PutMapping("/semestre/{id}")
    public ResponseEntity<String> atualizarSemestre(@PathVariable int id, @RequestBody Semestre semestre) {
        try {
            String resultado = semestreUseCase.atualizarSemestre(id, semestre);
            if ("Semestre não encontrado".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Semestre não encontrado para atualização."); // Retorna 404 se não encontrar o semestre
            }
            return ResponseEntity.status(HttpStatus.OK).body("Semestre atualizado com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar semestre."); // Retorna 500 em caso de erro
        }
    }

    // Método GET para listar um semestre por ID
    @GetMapping("/semestre/{id}")
    public ResponseEntity<Semestre> listarId(@PathVariable int id) {
        try {
            Semestre semestre = semestreUseCase.listarid(id);
            if (semestre == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 Not Found se não encontrar o semestre
            }
            return ResponseEntity.ok(semestre); // Retorna 200 OK com o semestre encontrado
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }
}