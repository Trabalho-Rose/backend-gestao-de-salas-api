package br.com.cesurgmarau.SistemaRose.core.domain.contract;

import br.com.cesurgmarau.SistemaRose.core.domain.entity.Semestre;

import java.util.List;

public interface SemestreUseCase {

    public Semestre listarid(int id);
    public List<Semestre> listar ();
    public void adicionarSemestre (Semestre semestre);
    public String deletarSemestre (int id);
    public String atualizarSemestre (int id, Semestre semestre);


}
