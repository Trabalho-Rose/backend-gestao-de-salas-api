package br.com.cesurgmarau.SistemaRose.infra.controller;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.DiasDaSemanaUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.DiasDaSemana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DiasDaSemanaController {

    @Autowired
    private DiasDaSemanaUseCase diasDaSemanaUseCase;

    // Método GET para listar todos os dias da semana
    @GetMapping("/diasDaSemana")
    public ResponseEntity<List<DiasDaSemana>> listar() {
        try {
            List<DiasDaSemana> diasDaSemana = diasDaSemanaUseCase.listar();
            if (diasDaSemana.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content se não houver dados
            }
            return ResponseEntity.ok(diasDaSemana); // Retorna 200 OK com os dados
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }

    // Método GET para listar um dia específico da semana por ID
    @GetMapping("/diasDaSemana/{id}")
    public ResponseEntity<DiasDaSemana> listarPorId(@PathVariable int id) {
        try {
            DiasDaSemana diaDaSemana = diasDaSemanaUseCase.listarPorId(id);
            if (diaDaSemana == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 Not Found se não encontrar o dia
            }
            return ResponseEntity.ok(diaDaSemana); // Retorna 200 OK com o dado do dia
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna 500 em caso de erro
        }
    }

    // Método POST para adicionar um novo dia da semana
    @PostMapping("/diasDaSemana")
    public ResponseEntity<String> adicionarDiasDaSemana(@RequestBody DiasDaSemana diasDaSemana) {
        try {
            diasDaSemanaUseCase.adicionarDiasDaSemana(diasDaSemana);
            return ResponseEntity.status(HttpStatus.CREATED).body("Dia da semana adicionado com sucesso."); // Retorna 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar o dia da semana."); // Retorna 500 em caso de erro
        }
    }

    // Método DELETE para deletar um dia da semana por ID
    @DeleteMapping("/diasDaSemana/{id}")
    public ResponseEntity<String> deletarDiasDaSemana(@PathVariable int id) {
        try {
            String resultado = diasDaSemanaUseCase.deletarDiasDaSemana(id);
            if ("Dia da semana não encontrado".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dia da semana não encontrado para exclusão."); // Retorna 404 se não encontrar o dia
            }
            return ResponseEntity.status(HttpStatus.OK).body("Dia da semana deletado com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o dia da semana."); // Retorna 500 em caso de erro
        }
    }

    // Método PUT para atualizar um dia da semana por ID
    @PutMapping("/diasDaSemana/{id}")
    public ResponseEntity<String> atualizarDiasDaSemana(@PathVariable int id, @RequestBody DiasDaSemana diasDaSemana) {
        try {
            String resultado = diasDaSemanaUseCase.atualizarDiasDaSemana(id, diasDaSemana);
            if ("Dia da semana não encontrado".equals(resultado)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dia da semana não encontrado para atualização."); // Retorna 404 se não encontrar o dia
            }
            return ResponseEntity.status(HttpStatus.OK).body("Dia da semana atualizado com sucesso."); // Retorna 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o dia da semana."); // Retorna 500 em caso de erro
        }
    }
}