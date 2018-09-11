package br.com.escola.service;

import java.util.List;

import br.com.escola.dto.ProfessorDTO;
import br.com.escola.service.exception.MaxDisponibilidadeException;

public interface ProfessorService {

	List<ProfessorDTO> getAll();

	ProfessorDTO save(ProfessorDTO professorDTO) throws MaxDisponibilidadeException;

	ProfessorDTO findByCpf(String cpf);
	
}
