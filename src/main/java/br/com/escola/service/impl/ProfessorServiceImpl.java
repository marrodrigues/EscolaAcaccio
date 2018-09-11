package br.com.escola.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escola.dto.DisponibilidadeDTO;
import br.com.escola.dto.ProfessorDTO;
import br.com.escola.repository.ProfessorRepository;
import br.com.escola.service.DisponibilidadeService;
import br.com.escola.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private DisponibilidadeService disponibilidadeService;

	@Override
	public List<ProfessorDTO> getAll() {
		return professorRepository.findAll();
	}

	@Override
	public ProfessorDTO save(ProfessorDTO professorDTO) {
		ProfessorDTO professor = findByCpf(professorDTO.getCpf());
		if (!Objects.isNull(professor)) {
			professorDTO.setProfessorId(professor.getProfessorId());
			if (professorDTO.getDisponibilidade().size() > 0) {
				professor = saveProfessorAndDisponibilidade(professorDTO);
			} else {
				professor = professorRepository.save(professorDTO);
			}
			return professor;
		} else {
			if (professorDTO.getDisponibilidade().size() > 0) {
				professor = saveProfessorAndDisponibilidade(professorDTO);
			} else {
				professor = professorRepository.save(professorDTO);
			}
		}
		return professor;
	}

	private ProfessorDTO saveProfessorAndDisponibilidade(ProfessorDTO professorDTO) {
		List<DisponibilidadeDTO> disponibilidade;
		ProfessorDTO professor;
		disponibilidade = new ArrayList<DisponibilidadeDTO>(professorDTO.getDisponibilidade());
		professorDTO.getDisponibilidade().clear();
		professor = professorRepository.save(professorDTO);
		disponibilidade.forEach(dia -> {
			dia.setProfessorId(professorDTO);
			professorDTO.getDisponibilidade().add(disponibilidadeService.save(dia));
		});
		return professor;
	}

	@Override
	public ProfessorDTO findByCpf(String cpf) {
		return professorRepository.findByCpf(cpf);
	}

}
