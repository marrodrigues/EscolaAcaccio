package br.com.escola.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escola.model.Disponibilidade;
import br.com.escola.model.Professor;
import br.com.escola.model.enumeration.DiaSemanaEnum;
import br.com.escola.repository.ProfessorRepository;
import br.com.escola.service.DisponibilidadeService;
import br.com.escola.service.ProfessorService;
import br.com.escola.service.exception.MaxDisponibilidadeException;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private DisponibilidadeService disponibilidadeService;

	@Override
	public List<Professor> getAll() {
		return professorRepository.findAll();
	}

	@Override
	public Professor save(Professor professorDTO) throws MaxDisponibilidadeException {
		Map<String, DiaSemanaEnum> DisponibilidadeMap = new HashMap<String, DiaSemanaEnum>();
		professorDTO.getDisponibilidade().forEach(dia -> {
			DisponibilidadeMap.put(dia.getDia().name(), dia.getDia());
		});

		if (DisponibilidadeMap.size() > 3) {
			throw new MaxDisponibilidadeException("O Professor pode lecionar no maximo em 3 dias.");
		}

		Professor professor = findByCpf(professorDTO.getCpf());

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

	private Professor saveProfessorAndDisponibilidade(Professor professorDTO) {
		List<Disponibilidade> disponibilidade;
		Professor professor;
		disponibilidade = new ArrayList<Disponibilidade>(professorDTO.getDisponibilidade());
		professorDTO.getDisponibilidade().clear();
		professor = professorRepository.save(professorDTO);
		disponibilidadeService.removeByProfessorId(professor);
		disponibilidade.forEach(dia -> {
			dia.setProfessorId(professorDTO);
			professorDTO.getDisponibilidade().add(disponibilidadeService.save(dia));
		});
		return professor;
	}

	@Override
	public Professor findByCpf(String cpf) {
		return professorRepository.findByCpf(cpf);
	}

}
