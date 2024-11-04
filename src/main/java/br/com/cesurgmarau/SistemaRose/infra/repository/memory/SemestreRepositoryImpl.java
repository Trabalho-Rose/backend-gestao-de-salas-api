package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SemestreRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Semestre;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.SituacaoSala;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SemestreRepositoryImpl implements SemestreRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarSemestre(Semestre semestre) {
        //INSERT INTO tabela VALUES ...
        //Named Parameters
        var query = """
                INSERT INTO semestre (data)
                VALUES (:data)
                """;
        entityManager.createNativeQuery(query, Semestre.class)
                .setParameter("data", semestre.getData())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarSemestre(int id, Semestre semestre) {
        var query = """
                UPDATE FROM semestre SET 
                data = :data
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Semestre.class)
                .setParameter("data", semestre.getData())
                .setParameter("id", id)
                .executeUpdate();
        return "Semestre atualizado com sucesso!";
    }

    @Transactional // Abre uma transação a ser executada no banco
    @Override
    public String deletarSemestre(int id) {
        var query = "DELETE FROM semestre WHERE id = :id";

        entityManager.createNativeQuery(query, Semestre.class).setParameter("id", id).executeUpdate();
        return "Semestre deletado com sucesso!";
    }

    @Override
    public List<Semestre> listar() {
        var query = "SELECT * FROM situacaoSala";

        return (List<Semestre>) entityManager.createNativeQuery(query, Semestre.class).getResultList();
    }

    @Override
    public Semestre listarid(int id) {
        var query = "SELECT * FROM semestre WHERE id = :id";

        return (Semestre) entityManager.createNativeQuery(query, Semestre.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}