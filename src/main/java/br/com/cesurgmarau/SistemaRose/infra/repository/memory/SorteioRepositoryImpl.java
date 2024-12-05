package br.com.cesurgmarau.SistemaRose.infra.repository.memory;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.SorteioRespository;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.ConsultaSorteio;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.SituacaoSala;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Sorteio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SorteioRepositoryImpl implements SorteioRespository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarSorteio (Sorteio sorteio) {
        //INSERT INTO tabela VALUES ...
        //Named Parameters
        var query = """
                INSERT INTO sorteio (id_curso, id_sala, id_professor, id_disciplina, id_turma)
                VALUES (:id_curso, :id_sala, :id_professor, :id_disciplina, :id_turma)
                """;
        entityManager.createNativeQuery(query, Sorteio.class)
                .setParameter("id_curso", sorteio.getId_curso())
                .setParameter("id_sala", sorteio.getId_sala())
                .setParameter("id_professor", sorteio.getId_professor())
                .setParameter("id_disciplina", sorteio.getId_disciplina())
                .setParameter("id_turma", sorteio.getId_turma())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarSorteio (int id, Sorteio sorteio) {
        var query = """
                UPDATE sorteio SET 
                id_curso = :id_curso,
                id_sala = :id_sala,
                id_professor = :id_professor,
                id_disciplina = :id_disciplina,
                id_turma = :id_turma
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, SituacaoSala.class)
                .setParameter("id_curso", sorteio.getId_curso())
                .setParameter("id_sala", sorteio.getId_sala())
                .setParameter("id_professor", sorteio.getId_professor())
                .setParameter("id_disciplina", sorteio.getId_disciplina())
                .setParameter("id_turma", sorteio.getId_turma())
                .setParameter("id", id)
                .executeUpdate();
        return "Relatório atualizado com sucesso!";
    }

    @Transactional
    @Override
    public String deletarSorteios () {
        var query = """
                DROP TABLE sorteio;
                """;

        entityManager.createNativeQuery(query, Sorteio.class).executeUpdate();

        var query2 = """
                CREATE TABLE sorteio (
                 id serial PRIMARY KEY,
                 id_curso INTEGER not null,
                 id_sala INTEGER not null,
                 id_professor INTEGER not null,
                 id_disciplina INTEGER not null,
                 id_turma INTEGER not null,
                                
                  FOREIGN KEY (id_sala) REFERENCES sala (id),
                  FOREIGN KEY (id_curso) REFERENCES curso (id),
                  FOREIGN KEY (id_professor) REFERENCES professor (id),
                  FOREIGN KEY (id_turma) REFERENCES turma (id),
                  FOREIGN KEY (id_disciplina) REFERENCES disciplina (id)
                );
                """;

        entityManager.createNativeQuery(query2)
                .executeUpdate();
        return "Todos os relatórios foram deletados!";
    }

    @Transactional // Abre uma transação a ser executada no banco
    @Override
    public String deletarSorteioPorId (int id) {
        var query = "DELETE FROM sorteio WHERE id = :id";

        entityManager.createNativeQuery(query, Sorteio.class).setParameter("id", id).executeUpdate();
        return "Relatório deletado com sucesso!";
    }

    @Override
    public List<ConsultaSorteio> listarSorteios () {
        var query = """
                    SELECT s.id AS idSorteio c.nome as curso, sa.nome as sala, p.nome as professor, d.nome as disciplina, t.nome as turma from sorteio s
                    INNER JOIN sala sa on sa.id = s.id_sala
                    INNER JOIN curso c on c.id = s.id_curso
                    INNER JOIN professor p on p.id = s.id_professor
                    INNER JOIN turma t on t.id = s.id_turma
                    INNER JOIN disciplina d on d.id = s.id_disciplina
                    """;

        return (List<ConsultaSorteio>) entityManager.createNativeQuery(query, ConsultaSorteio.class).getResultList();
    }

    @Override
    public ConsultaSorteio listarSorteioPorId (int id) {
        var query = """
                SELECT s.id AS idSorteio c.nome as curso, sa.nome as sala, p.nome as professor, d.nome as disciplina, t.nome as turma from sorteio s\n" +
                INNER JOIN sala sa on sa.id = s.id_sala
                INNER JOIN curso c on c.id = s.id_curso
                INNER JOIN professor p on p.id = s.id_professor
                INNER JOIN turma t on t.id = s.id_turma
                INNER JOIN disciplina d on d.id = s.id_disciplina
                WHERE s.id = :id;
                """;

        return (ConsultaSorteio) entityManager.createNativeQuery(query, ConsultaSorteio.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}