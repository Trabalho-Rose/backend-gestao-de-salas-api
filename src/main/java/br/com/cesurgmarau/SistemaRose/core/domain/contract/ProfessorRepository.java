package br.com.cesurgmarau.SistemaRose.core.domain.contract;
import br.com.cesurgmarau.SistemaRose.core.domain.entity.Professor;

import java.util.List;

public interface ProfessorRepository {

    public List<Professor> listar ();
    public Professor listarPorId (int id);
    public void adicionarProfessor (Professor professor);
    public String deletarProfessor (int id);
    public String atualizarProfessor (int id, Professor professor);
}