package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.TurmaRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TurmaRepositoryImpl implements TurmaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarturma(Turma turma) {
        //INSERT INTO tabela VALUES ...
        //Named Parameters
        var query = """
                INSERT INTO turma (nome, qtdalunos, curso_id)
                VALUES (:nome, :qtdalunos, :curso_id)
                """;
        entityManager.createNativeQuery(query, Turma.class)
                .setParameter("nome", turma.getNome())
                .setParameter("qtdalunos", turma.getQtdAlunos())
                .setParameter("curso_id", turma.getCurso_id())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarturma(int id, Turma turma) {
        var query = """
                UPDATE turma SET 
                nome = :nome,
                qtdalunos = :qtdalunos,
                curso_id = :curso_id
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Turma.class)
                .setParameter("nome", turma.getNome())
                .setParameter("qtdalunos", turma.getQtdAlunos())
                .setParameter("curso_id", turma.getCurso_id())
                .setParameter("id", id)
                .executeUpdate();
        return "Turma atualizada com sucesso!";
    }

    @Transactional // Abre uma transação a ser executada no banco
    @Override
    public String deletarturma(int id) {
        var query = "DELETE FROM turma WHERE id = :id";

        entityManager.createNativeQuery(query, Turma.class).setParameter("id", id).executeUpdate();
        return "Turma deletada com sucesso!";
    }

    @Override
    public List<Turma> listar() {
        var query = "SELECT * FROM turma";

        return (List<Turma>) entityManager.createNativeQuery(query, Turma.class).getResultList();
    }

    @Override
    public Turma listarid(int id) {
        var query = "SELECT * FROM turma WHERE id = :id";

        return (Turma) entityManager.createNativeQuery(query, Turma.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
