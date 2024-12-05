package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.DiasDaSemanaRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Curso;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.DiasDaSemana;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiasDaSemanaRepositoryImpl implements DiasDaSemanaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarDiasDaSemana(DiasDaSemana diasDaSemana) {
        //INSERT INTO tabela VALUES ...
        //Named Parameters
        var query = """
                INSERT INTO diasdasemana (diatrabalhado)
                VALUES (:diatrabalhado)
                """;
        entityManager.createNativeQuery(query, DiasDaSemana.class)
                .setParameter("diatrabalhado", diasDaSemana.getDiaTrabalhado())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarDiasDaSemana(int id, DiasDaSemana diasDaSemana) {
        var query = """
                UPDATE diasdasemana SET 
                diatrabalhado = :diatrabalhado
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Curso.class)
                .setParameter("diatrabalhado", diasDaSemana.getDiaTrabalhado())
                .setParameter("id", id)
                .executeUpdate();
        return "Dia da semana atualizado com sucesso!";
    }

    @Transactional // Abre uma transação a ser executada no banco
    @Override
    public String deletarDiasDaSemana (int id) {
        var query = "DELETE FROM diasdasemana WHERE id = :id";

        entityManager.createNativeQuery(query, DiasDaSemana.class).setParameter("id", id).executeUpdate();
        return "Dia da semana deletado com sucesso!";
    }

    @Override
    public List<DiasDaSemana> listar() {
        var query = "SELECT * FROM diasdasemana";

        return (List<DiasDaSemana>) entityManager.createNativeQuery(query, DiasDaSemana.class).getResultList();
    }

    @Override
    public DiasDaSemana listarPorId(int id) {
        var query = "SELECT * FROM diasdasemana WHERE id = :id";

        return (DiasDaSemana) entityManager.createNativeQuery(query, DiasDaSemana.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}

