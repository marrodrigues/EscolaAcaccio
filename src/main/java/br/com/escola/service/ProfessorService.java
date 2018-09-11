package br.com.escola.service;

import java.util.List;

import br.com.escola.dto.ProfessorDTO;

public interface ProfessorService {

	List<ProfessorDTO> getAll();

	ProfessorDTO save(ProfessorDTO professorDTO);

	ProfessorDTO findByCpf(String cpf);
	
}
