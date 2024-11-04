package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.DisciplinaRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Disciplina;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DisciplinaRepositoryImpl implements DisciplinaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarDisciplina(Disciplina disciplina) {
        //INSERT INTO tabela VALUES ...
        //Named Parameters
        var query = """
                INSERT INTO disciplina (nome, cargaHoraria, professor_id, curso_id)
                VALUES (:nome, :cargaHoraria, :professor_id, :curso_id)
                """;
        entityManager.createNativeQuery(query, Disciplina.class)
                .setParameter("nome", disciplina.getNome())
                .setParameter("cargaHoraria", disciplina.getCargaHoraria())
                .setParameter("professor_id", disciplina.getProfessor_id())
                .setParameter("curso_id", disciplina.getCurso_id())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarDisciplina(int id, Disciplina disciplina) {
        var query = """
                UPDATE FROM disciplina SET 
                nome = :nome,
                cargaHoraria = :cargaHoraria,
                professor_id = :professor_id,
                curso_id = :curso_id,
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Disciplina.class)
                .setParameter("nome", disciplina.getNome())
                .setParameter("cargaHoraria", disciplina.getCargaHoraria())
                .setParameter("professor_id", disciplina.getProfessor_id())
                .setParameter("curso_id", disciplina.getCurso_id())
                .setParameter("id", id)
                .executeUpdate();
        return "Disciplina atualizada com sucesso!";
    }

    @Transactional // Abre uma transação a ser executada no banco
    @Override
    public String deletarDisciplina(int id) {
        var query = "DELETE FROM disciplina WHERE id = :id";

        entityManager.createNativeQuery(query, Disciplina.class).setParameter("id", id).executeUpdate();
        return "Disciplina deletada com sucesso!";
    }

    @Override
    public List<Disciplina> listar() {
        var query = "SELECT * FROM disciplina";

        return (List<Disciplina>) entityManager.createNativeQuery(query, Disciplina.class).getResultList();
    }

    @Override
    public Disciplina listarPorId(int id) {
        var query = "SELECT * FROM disciplina WHERE id = :id";

        return (Disciplina) entityManager.createNativeQuery(query, Disciplina.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}