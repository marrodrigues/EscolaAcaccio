package br.com.escola.service;

import java.util.List;

import br.com.escola.model.Professor;
import br.com.escola.service.exception.MaxDisponibilidadeException;
import br.com.escola.service.exception.MinDisponibilidadeException;

public interface ProfessorService {

	List<Professor> getAll();

	Professor save(Professor professorDTO) throws MaxDisponibilidadeException, MinDisponibilidadeException;

	Professor findByCpf(String cpf);

}
