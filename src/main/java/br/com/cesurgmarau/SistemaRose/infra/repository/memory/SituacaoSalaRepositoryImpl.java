package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SituacaoSalaRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.SituacaoSala;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SituacaoSalaRepositoryImpl implements SituacaoSalaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarSituacaoSala(SituacaoSala situacaoSala) {
        //INSERT INTO tabela VALUES ...
        //Named Parameters
        var query = """
                INSERT INTO situacaoSala (situacaoSala)
                VALUES (:situacaoSala)
                """;
        entityManager.createNativeQuery(query, SituacaoSala.class)
                .setParameter("situacaoSala", situacaoSala.getSituacaoSala())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarSituacaoSala(int id, SituacaoSala situacaoSala) {
        var query = """
                UPDATE FROM situacaoSala SET 
                situacaoSala = :situacaoSala
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, SituacaoSala.class)
                .setParameter("nome", situacaoSala.getSituacaoSala())
                .setParameter("id", id)
                .executeUpdate();
        return "Situacao de sala atualizada com sucesso!";
    }

    @Transactional // Abre uma transação a ser executada no banco
    @Override
    public String deletarSituacaoSala(int id) {
        var query = "DELETE FROM situacaoSala WHERE id = :id";

        entityManager.createNativeQuery(query, SituacaoSala.class).setParameter("id", id).executeUpdate();
        return "Situação de sala deletada com sucesso!";
    }

    @Override
    public List<SituacaoSala> listar() {
        var query = "SELECT * FROM situacaoSala";

        return (List<SituacaoSala>) entityManager.createNativeQuery(query, SituacaoSala.class).getResultList();
    }

    @Override
    public SituacaoSala listarid(int id) {
        var query = "SELECT * FROM situacaoSala WHERE id = :id";

        return (SituacaoSala) entityManager.createNativeQuery(query, SituacaoSala.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}