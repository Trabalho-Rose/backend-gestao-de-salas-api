package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.CursoRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Curso;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Disciplina;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepositoryImpl implements CursoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarCurso(Curso curso) {
        //INSERT INTO tabela VALUES ...
        //Named Parameters
        var query = """
                INSERT INTO curso (nome, descricao)
                VALUES (:nome, :descricao)
                """;
        entityManager.createNativeQuery(query, Curso.class)
                .setParameter("nome", curso.getNome())
                .setParameter("descricao", curso.getDescricao())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarCurso(int id, Curso curso) {
        var query = """
                UPDATE FROM curso SET 
                nome = :nome,
                descricao = :descricao,
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Curso.class)
                .setParameter("nome", curso.getNome())
                .setParameter("descricao", curso.getDescricao())
                .setParameter("id", id)
                .executeUpdate();
        return "Curso atualizado com sucesso!";
    }

    @Transactional // Abre uma transação a ser executada no banco
    @Override
    public String deletarCurso(int id) {
        var query = "DELETE FROM curso WHERE id = :id";

        entityManager.createNativeQuery(query, Curso.class).setParameter("id", id).executeUpdate();
        return "Curso deletado com sucesso!";
    }

    @Override
    public List<Curso> listar() {
        var query = "SELECT * FROM curso";

        return (List<Curso>) entityManager.createNativeQuery(query, Curso.class).getResultList();
    }

    @Override
    public Curso listarPorId(int id) {
        var query = "SELECT * FROM curso WHERE id = :id";

        return (Curso) entityManager.createNativeQuery(query, Curso.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}