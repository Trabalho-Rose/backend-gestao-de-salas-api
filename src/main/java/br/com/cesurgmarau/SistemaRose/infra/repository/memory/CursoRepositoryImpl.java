package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.CursoRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Curso;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Disciplina;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.ListarDisciplinas;
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

    @Transactional
    @Override
    public void adicionarDisciplina(int cursoID, int disciplinaID) {
        var query = """
                INSERT INTO curso_disciplina (curso_id, disciplina_id) VALUES (:curso_id, :disciplina_id)
                """;

        entityManager.createNativeQuery(query, Curso.class)
                .setParameter("curso_id", cursoID)
                .setParameter("disciplina_id", disciplinaID)
                .executeUpdate();
    }


    @Override
    public List<ListarDisciplinas> listarDisciplinasPorCurso (int cursoID) {
        var query = """ 
                SELECT c.id, c.nome AS nomeCurso, d.nome AS disciplina, d.cargaHoraria AS cargaHoraria FROM curso c
                INNER JOIN curso_disciplina cd ON c.id = cd.curso_id
                INNER JOIN disciplina d ON cd.disciplina_id = d.id
                WHERE curso_id = :curso_id
                """;

        return entityManager.createNativeQuery(query, ListarDisciplinas.class)
                .setParameter("curso_id", cursoID)
                .getResultList();

    }
}