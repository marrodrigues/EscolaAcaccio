package br.com.escola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escola.dto.ProfessorDTO;
import br.com.escola.repository.ProfessorRepository;
import br.com.escola.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService{

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Override
	public List<ProfessorDTO> getAll() {
		return professorRepository.findAll();
	}

	@Override
	public ProfessorDTO save(ProfessorDTO professorDTO) {
		return professorRepository.save(professorDTO);
	}

}
