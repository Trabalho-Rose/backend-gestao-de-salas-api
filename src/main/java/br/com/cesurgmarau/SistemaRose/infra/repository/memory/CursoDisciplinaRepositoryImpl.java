package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.CursoDisciplinaRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.CursoDisciplina;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Sala;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Semestre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CursoDisciplinaRepositoryImpl implements CursoDisciplinaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarCursoDisciplina(CursoDisciplina cursoDisciplina) {
        //INSERT INTO tabela VALUES ...
        //Named Parameters
        var query = """
                INSERT INTO curso_disciplina (curso_id, disciplina_id)
                VALUES (:curso_id, :disciplina)
                """;
        entityManager.createNativeQuery(query, CursoDisciplina.class)
                .setParameter("curso_id", cursoDisciplina.getCurso_id())
                .setParameter("disciplina_id", cursoDisciplina.getDisciplina_id())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarCursoDisciplina(int id, CursoDisciplina cursoDisciplina) {
        var query = """
                UPDATE FROM curso_disciplina SET 
                curso_id = :curso_id,
                disciplina_id = :disciplina_id
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, CursoDisciplina.class)
                .setParameter("curso_id", cursoDisciplina.getCurso_id())
                .setParameter("disciplina_id", cursoDisciplina.getDisciplina_id())
                .setParameter("id", id)
                .executeUpdate();
        return "Curso e disciplina vinculados com sucesso!";
    }

    @Transactional // Abre uma transação a ser executada no banco
    @Override
    public String deletarCursoDisciplina (int id) {
        var query = "DELETE FROM curso_disciplina WHERE id = :id";

        entityManager.createNativeQuery(query, CursoDisciplina.class).setParameter("id", id).executeUpdate();
        return "Curso e disciplina desvinculados com sucesso!";
    }

    @Override
    public List<CursoDisciplina> listar() {
        var query = "SELECT * FROM curso_disciplina";

        return (List<CursoDisciplina>) entityManager.createNativeQuery(query, CursoDisciplina.class).getResultList();
    }

    @Override
    public CursoDisciplina listarPorId(int id) {
        var query = "SELECT * FROM curso_disciplina WHERE id = :id";

        return (CursoDisciplina) entityManager.createNativeQuery(query, CursoDisciplina.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
