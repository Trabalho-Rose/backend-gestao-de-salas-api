package br.com.cesurgmarau.SistemaRose.core.usecase;

import br.com.cesurgmarau.SistemaRose.core.domain.contract.CursoRepository;
import br.com.cesurgmarau.SistemaRose.core.domain.contract.CursoUseCase;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Curso;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Disciplina;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.ListarDisciplinas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//controle de injeção de dependências
public class CursoUseCaseImpl implements CursoUseCase {

        @Autowired
        //injeção de dependências - nesse caso está injetando o contrato do repositório que possui os métodos (funções)
        //tira a necessidade do acoplamento --> (FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryImpl()
        //tira a necessidade de mexer na regra de negócio (use case) se for trocar o banco ou etc.
        private CursoRepository cursoRepository;
        private Curso curso;

        @Override
        public List<Curso> listar() {
            return cursoRepository.listar();
        }

        @Override
        public Curso listarPorId (int id) {
            return cursoRepository.listarPorId(id);
        }

        @Override
        public void adicionarCurso (Curso curso) {
            cursoRepository.adicionarCurso(curso);
        }

        @Override
        public String deletarCurso (int id) {
            return cursoRepository.deletarCurso(id);
        }

        @Override
        public String atualizarCurso (int id, Curso curso) {
            return cursoRepository.atualizarCurso(id, curso);
        }

        @Override
        public void adicionarDisciplina(int cursoID, int disciplinaID) {
            cursoRepository.adicionarDisciplina(cursoID, disciplinaID);
        }

        @Override
        public List<ListarDisciplinas> listarDisciplinasPorCurso (int cursoID) {
            return cursoRepository.listarDisciplinasPorCurso(cursoID);
        }
}