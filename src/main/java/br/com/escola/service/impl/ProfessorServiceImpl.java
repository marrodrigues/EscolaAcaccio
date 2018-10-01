package br.com.escola.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escola.model.Disponibilidade;
import br.com.escola.model.Materia;
import br.com.escola.model.Periodo;
import br.com.escola.model.Professor;
import br.com.escola.repository.PeriodoRepository;
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
	
	@Autowired
	private PeriodoRepository periodoRepository;

	@Override
	public List<Professor> getAll() {
		return professorRepository.findAll();
	}

	@Override
	public Professor save(Professor professorDTO) throws MaxDisponibilidadeException {
		Map<Integer, Integer> DisponibilidadeMap = new HashMap<Integer, Integer>();
		professorDTO.getDisponibilidade().forEach(dia -> {
			if(dia.getPeriods().size() > 0) {
				DisponibilidadeMap.put(dia.getDay(), dia.getDay());
			}
		});

		if (DisponibilidadeMap.size() > 3) {
			throw new MaxDisponibilidadeException("O Professor pode lecionar no maximo em 3 dias.");
		}

		Professor professor = findByCpf(professorDTO.getCpf());

		if (!Objects.isNull(professor)) {

			professorDTO.setProfessorId(professor.getProfessorId());

			if (professorDTO.getDisponibilidade().size() > 0) {
				professor = saveProfessorMateriaDisponibilidade(professorDTO);
			} else {
				professor = professorRepository.save(professorDTO);
			}

			return professor;

		} else {

			if (professorDTO.getDisponibilidade().size() > 0) {
				professor = saveProfessorMateriaDisponibilidade(professorDTO);
			} else {
				professor = professorRepository.save(professorDTO);
			}

		}

		return professor;
	}

	private Professor saveProfessorMateriaDisponibilidade(Professor professorDTO) {
		List<Disponibilidade> disponibilidade = new ArrayList<Disponibilidade>(professorDTO.getDisponibilidade());
		Professor professor;
		professorDTO.getDisponibilidade().clear();
		professor = professorRepository.save(professorDTO);
		disponibilidadeService.removeByProfessorId(professor);
		disponibilidade.forEach(dia -> {
			List<Periodo> periodo = new ArrayList<>(dia.getPeriods());
			dia.getPeriods().clear();
			dia.setProfessorId(professorDTO);
			Disponibilidade save = disponibilidadeService.save(dia);
			periodo.forEach(period -> {
				period.setDisponibilidadeId(save);
				period = periodoRepository.save(period);
				dia.getPeriods().add(period);
			});
			professor.getDisponibilidade().add(dia);
		});
		return professor;
	}

	@Override
	public Professor findByCpf(String cpf) {
		return professorRepository.findByCpf(cpf);
	}

}
