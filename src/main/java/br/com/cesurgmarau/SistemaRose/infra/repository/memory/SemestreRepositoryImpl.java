package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SemestreRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Semestre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

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
                INSERT INTO semestre (data, turma_id)
                VALUES (:data, :turma_id)
                """;
        entityManager.createNativeQuery(query, Semestre.class)
                .setParameter("data", semestre.getData())
                .setParameter("turma_id", semestre.getTurma_id())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarSemestre(int id, Semestre semestre) {
        var query = """
                UPDATE semestre SET 
                data = :data
                turma_id = :turma_id
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Semestre.class)
                .setParameter("data", semestre.getData())
                .setParameter("turma_id", semestre.getTurma_id())
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
        var query = "SELECT * FROM semestre";

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