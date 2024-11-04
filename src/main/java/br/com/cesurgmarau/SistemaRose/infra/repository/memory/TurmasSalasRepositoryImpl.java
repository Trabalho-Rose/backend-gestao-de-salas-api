package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.TurmasSalasRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.TurmasSalas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TurmasSalasRepositoryImpl implements TurmasSalasRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarTurmasSalas(TurmasSalas turmasSalas) {
        //INSERT INTO tabela VALUES ...
        //Named Parameters
        var query = """
                INSERT INTO turmas_salas (turma_id, sala_id)
                VALUES (:turma_id, :sala_id)
                """;
        entityManager.createNativeQuery(query, TurmasSalas.class)
                .setParameter("turma_id", turmasSalas.getTurma_id())
                .setParameter("sala_id", turmasSalas.getSala_id())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarTurmasSalas(int id, TurmasSalas turmasSalas) {
        var query = """
                UPDATE FROM turmas_salas SET 
                turma_id = :turma_id,
                sala_id = :sala_id
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, TurmasSalas.class)
                .setParameter("turma_id", turmasSalas.getTurma_id())
                .setParameter("sala_id", turmasSalas.getSala_id())
                .setParameter("id", id)
                .executeUpdate();
        return "Sala da turma atualizada com sucesso!";
    }

    @Transactional // Abre uma transação a ser executada no banco
    @Override
    public String deletarTurmasSalas(int id) {
        var query = "DELETE FROM turmas_salas WHERE id = :id";

        entityManager.createNativeQuery(query, TurmasSalas.class).setParameter("id", id).executeUpdate();
        return "Sala da turma deletada com sucesso!";
    }

    @Override
    public List<TurmasSalas> listar() {
        var query = "SELECT * FROM turmas_salas";

        return (List<TurmasSalas>) entityManager.createNativeQuery(query, TurmasSalas.class).getResultList();
    }

    @Override
    public TurmasSalas listarPorId(int id) {
        var query = "SELECT * FROM turmas_salas WHERE id = :id";

        return (TurmasSalas) entityManager.createNativeQuery(query, TurmasSalas.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}