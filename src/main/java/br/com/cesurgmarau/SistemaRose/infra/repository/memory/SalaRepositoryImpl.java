package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SalaRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Sala;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Semestre;
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
                INSERT INTO sala (nome, capacidade, situacaoSala_id)
                VALUES (:nome, :capacidade, :situacaoSala_id)
                """;
        entityManager.createNativeQuery(query, Sala.class)
                .setParameter("nome", sala.getNome())
                .setParameter("capacidade", sala.getCapacidade())
                .setParameter("situacaoSala_id", sala.getSituacaoSala_id())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarSala(int id, Sala sala) {
        var query = """
                UPDATE FROM sala SET 
                nome = :nome,
                capacidade = :capacidade,
                situacaoSala_id = :situacaoSala_id
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Semestre.class)
                .setParameter("nome", sala.getNome())
                .setParameter("capacidade", sala.getCapacidade())
                .setParameter("situacaoSala_id", sala.getSituacaoSala_id())
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
}