package br.com.escola.service;

import java.util.List;

import br.com.escola.model.Disponibilidade;
import br.com.escola.model.Professor;

public interface DisponibilidadeService {

	Disponibilidade save(Disponibilidade dia);

	List<Disponibilidade> findAll();

	void removeByProfessorId(Professor professorId);

}
