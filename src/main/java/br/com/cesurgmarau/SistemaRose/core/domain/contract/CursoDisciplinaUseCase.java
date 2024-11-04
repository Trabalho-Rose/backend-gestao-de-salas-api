package br.com.cesurgmarau.SistemaRose.core.domain.contract;

import br.com.cesurgmarau.SistemaRose.core.domain.entity.CursoDisciplina;

import java.util.List;

public interface CursoDisciplinaUseCase {

    public List<CursoDisciplina> listar ();
    public CursoDisciplina listarPorId (int id);
    public void adicionarCursoDisciplina (CursoDisciplina cursoDisciplina);
    public String deletarCursoDisciplina (int id);
    public String atualizarCursoDisciplina (int id, CursoDisciplina cursoDisciplina);

}
