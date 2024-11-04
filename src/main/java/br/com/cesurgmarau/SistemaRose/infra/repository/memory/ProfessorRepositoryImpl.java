package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.ProfessorRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfessorRepositoryImpl implements ProfessorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarProfessor(Professor professor) {
        //INSERT INTO tabela VALUES ...
        //Named Parameters
        var query = """
                INSERT INTO professor (nome, diaTrabalhado_id)
                VALUES (:nome, :diaTrabalhado_id)
                """;
        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("nome", professor.getNome())
                .setParameter("diaTrabalhado_id", professor.getDiaTrabalhado_id())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarProfessor(int id, Professor professor) {
        var query = """
                UPDATE FROM professor SET 
                nome = :nome,
                diaTrabalhado_id = :diaTrabalhado_id,
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Professor.class)
                .setParameter("nome", professor.getNome())
                .setParameter("diaTrabalhado_id", professor.getDiaTrabalhado_id())
                .setParameter("id", id)
                .executeUpdate();
        return "Professor atualizado com sucesso!";
    }

    @Transactional // Abre uma transação a ser executada no banco
    @Override
    public String deletarProfessor(int id) {
        var query = "DELETE FROM professor WHERE id = :id";

        entityManager.createNativeQuery(query, Professor.class).setParameter("id", id).executeUpdate();
        return "Professor deletado com sucesso!";
    }

    @Override
    public List<Professor> listar() {
        var query = "SELECT * FROM professor";

        return (List<Professor>) entityManager.createNativeQuery(query, Professor.class).getResultList();
    }

    @Override
    public Professor listarPorId(int id) {
        var query = "SELECT * FROM sala WHERE id = :id";

        return (Professor) entityManager.createNativeQuery(query, Professor.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
