package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SalaRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SalaRepositoryImpl implements SalaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarSala(Sala sala) {
        //INSERT INTO tabela VALUES ...
        //Named Parameters
        var query = """
                INSERT INTO sala (nome, capacidade, situacaoDeSala)
                VALUES (:nome, :capacidade, :situacaoDeSala)
                """;
        entityManager.createNativeQuery(query, Sala.class)
                .setParameter("nome", sala.getNome())
                .setParameter("capacidade", sala.getCapacidade())
                .setParameter("situacaoDeSala", sala.getSituacaoDeSala())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarSala(int id, Sala sala) {
        var query = """
                UPDATE sala SET 
                nome = :nome,
                capacidade = :capacidade,
                situacaoDeSala = :situacaoDeSala
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Semestre.class)
                .setParameter("nome", sala.getNome())
                .setParameter("capacidade", sala.getCapacidade())
                .setParameter("situacaosala_id", sala.getSituacaoDeSala())
                .setParameter("id", id)
                .executeUpdate();
        return "Sala atualizada com sucesso!";
    }

    @Transactional // Abre uma transação a ser executada no banco
    @Override
    public String deletarSala(int id) {
        var query = "DELETE FROM sala WHERE id = :id";

        entityManager.createNativeQuery(query, Sala.class).setParameter("id", id).executeUpdate();
        return "Sala deletada com sucesso!";
    }

    @Override
    public List<Sala> listar() {
        var query = "SELECT * FROM sala";

        return (List<Sala>) entityManager.createNativeQuery(query, Sala.class).getResultList();
    }

    @Override
    public Sala listarPorId(int id) {
        var query = "SELECT * FROM sala WHERE id = :id";

        return (Sala) entityManager.createNativeQuery(query, Sala.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @Transactional
    public String vincularTurma(int salaID, int turmaID) {

        var query1 = """
        SELECT s.capacidade FROM sala s WHERE s.id = :id
        """;
        int capacidade = (int) entityManager.createNativeQuery(query1)
                .setParameter("id", salaID)
                .getSingleResult();

        var query2 = """
        SELECT t.qtdalunos FROM turma t WHERE t.id = :id
        """;
        int qtdAlunos = (int) entityManager.createNativeQuery(query2)
                .setParameter("id", turmaID)
                .getSingleResult();

        var query4 = """
        SELECT ts.turma_id FROM turmas_salas ts WHERE ts.turma_id = :turma_id
        """;
        List<?> turmaResult = entityManager.createNativeQuery(query4)
                .setParameter("turma_id", turmaID)
                .getResultList();

        var query5 = """
        SELECT ts.sala_id FROM turmas_salas ts WHERE ts.sala_id = :sala_id
        """;
        List<?> salaResult = entityManager.createNativeQuery(query5)
                .setParameter("sala_id", salaID)
                .getResultList();

        if (turmaResult.isEmpty() && salaResult.isEmpty()) {
            if (capacidade >= qtdAlunos) {
                var query3 = """
                INSERT INTO turmas_salas (turma_id, sala_id) 
                VALUES (:turma_id, :sala_id);
                """;
                entityManager.createNativeQuery(query3)
                        .setParameter("turma_id", turmaID)
                        .setParameter("sala_id", salaID)
                        .executeUpdate();

                entityManager.flush();
                entityManager.clear();

                return "Sala reservada com sucesso!";
            } else {
                return "Capacidade da sala inferior à quantidade de alunos da turma!";
            }
        } else {
            var query6 = """
            SELECT t.nome AS turma FROM turmas_salas ts
            INNER JOIN turma t ON ts.turma_id = t.id
            INNER JOIN sala s ON ts.sala_id = s.id
            WHERE s.id = :sala_id
        """;
            String turma = (String) entityManager.createNativeQuery(query6)
                    .setParameter("sala_id", salaID)
                    .getSingleResult();

            var query7 = """
            SELECT s.nome AS sala FROM turmas_salas ts
            INNER JOIN sala s ON ts.sala_id = s.id
            INNER JOIN turma t ON ts.turma_id = t.id
            WHERE t.id = :turma_id
        """;
            String sala = (String) entityManager.createNativeQuery(query7)
                    .setParameter("turma_id", turmaID)
                    .getSingleResult();

            return "Sala ou Turma já vinculada! \n " + "A turma " + turma + " já está na sala " + sala;
        }
    }

    @Override
    @Transactional
    public void reiniciarTabela () {
        var query1 = """
                DROP TABLE turmas_salas;
                """;

        entityManager.createNativeQuery(query1, Sala.class)
                .executeUpdate();

        var query2 = """
                CREATE TABLE turmas_salas (
                    id SERIAL PRIMARY KEY,
                    turma_id INTEGER NOT NULL,
                    sala_id INTEGER NOT NULL,
                    
                    
                     FOREIGN KEY (turma_id) REFERENCES turma (id),
                     FOREIGN KEY (sala_id) REFERENCES sala (id)
                );
                """;

        entityManager.createNativeQuery(query2, Sala.class)
                .executeUpdate();

    }

    @Override
    public List<VinculoSalasETurmas> listarTurmasESalas () {
        var query = """
                SELECT t.id AS id_turma, t.nome AS turma, s.id AS id_sala, s.nome AS sala FROM turma t
                INNER JOIN turmas_salas ts ON t.id = ts.turma_id
                INNER JOIN sala s ON ts.sala_id = s.id
                """;

        return entityManager.createNativeQuery(query, VinculoSalasETurmas.class)
                .getResultList();
    }
}