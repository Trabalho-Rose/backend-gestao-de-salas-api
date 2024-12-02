package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SorteioUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.ConsultaSorteio;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Sorteio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SorteioController {

    @Autowired
    private SorteioUseCase sorteioUseCase;

    // Método POST para adicionar um sorteio
    @PostMapping("/sorteio")
    public ResponseEntity<String> adicionarSorteio(@RequestBody Sorteio sorteio) {
        try {
            sorteioUseCase.adicionarSorteio(sorteio);
            return ResponseEntity.status(HttpStatus.CREATED).body("Sorteio adicionado com sucesso."); // Retorna 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar sorteio."); // Retorna 500 em caso de erro
        }
    }

    // Método GET para listar todos os sorteios
    @GetMapping("/sorteio")
    public ResponseEntity<List<ConsultaSorteio>> listarSorteios() {
        try {
            List<ConsultaSorteio> sorteios = sorteioUseCase.listarSorteios();
            if (sorteios.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content se não houver sorteios
            }
            return ResponseEntity.ok(sorteios); // Retorna 200 OK com a lista de sorteios
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }

    // Método GET para listar um sorteio por ID
    @GetMapping("/sorteio/{id}")
    public ResponseEntity<Sorteio> listarSorteioPorId(@PathVariable int id) {
        try {
            Sorteio sorteio = sorteioUseCase.listarSorteioPorId(id);
            if (sorteio == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 Not Found se não encontrar o sorteio
            }
            return ResponseEntity.ok(sorteio); // Retorna 200 OK com o sorteio encontrado
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }

    // Método PUT para atualizar um sorteio por ID
    @PutMapping("/sorteio/{id}")
    public ResponseEntity<String> atualizarSorteio(@PathVariable int id, @RequestBody Sorteio sorteio) {
        try {
            String resultado = sorteioUseCase.atualizarSorteio(id, sorteio);
            if ("Sorteio não encontrado".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorteio não encontrado para atualização."); // Retorna 404 se não encontrar o sorteio
            }
            return ResponseEntity.status(HttpStatus.OK).body("Sorteio atualizado com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar sorteio."); // Retorna 500 em caso de erro
        }
    }

    // Método DELETE para deletar todos os sorteios
    @DeleteMapping("/sorteio")
    public ResponseEntity<String> deletarSorteios() {
        try {
            sorteioUseCase.deletarSorteios();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Todos os sorteios foram deletados com sucesso."); // Retorna 204 No Content
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar sorteios."); // Retorna 500 em caso de erro
        }
    }

    // Método DELETE para deletar um sorteio por ID
    @DeleteMapping("/sorteio/{id}")
    public ResponseEntity<String> deletarSorteioPorId(@PathVariable int id) {
        try {
            String resultado = sorteioUseCase.deletarSorteioPorId(id);
            if ("Sorteio não encontrado".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorteio não encontrado para exclusão."); // Retorna 404 se não encontrar o sorteio
            }
            return ResponseEntity.status(HttpStatus.OK).body("Sorteio deletado com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar sorteio."); // Retorna 500 em caso de erro
        }
    }
}