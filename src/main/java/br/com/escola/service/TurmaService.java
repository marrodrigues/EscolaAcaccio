package br.com.escola.service;

import java.util.List;

import br.com.escola.model.Turma;

public interface TurmaService {

	List<Turma> getAll();
	
	Turma findByCodigo(String codigo);

	Turma save(Turma turma);

}
