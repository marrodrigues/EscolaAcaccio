package br.com.escola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escola.model.Disponibilidade;
import br.com.escola.model.Professor;
import br.com.escola.repository.DisponibilidadeRepository;
import br.com.escola.repository.PeriodoRepository;
import br.com.escola.service.DisponibilidadeService;

@Service
public class DisponibilidadeServiceImpl implements DisponibilidadeService {

	@Autowired
	private DisponibilidadeRepository disponibilidadeRepository;
	
	@Autowired
	private PeriodoRepository periodoRepository;

	@Override
	public Disponibilidade save(Disponibilidade dia) {
		findAll().forEach(diaSalvo -> {
			if (dia.getDay().equals(diaSalvo.getDay())) {
				dia.getPeriods().forEach(period -> {
				if(diaSalvo.getPeriods().contains(period)){
					return;	
				}});
			}
		});
		return disponibilidadeRepository.save(dia);
	}

	@Override
	public List<Disponibilidade> findAll() {
		return disponibilidadeRepository.findAll();
	}
	
	@Override
	public void removeByProfessorId(Professor professorId) {
		List<Disponibilidade> findByProfessorId = disponibilidadeRepository.findByProfessorId(professorId);
		findByProfessorId.forEach(disp -> {
			periodoRepository.removeByDisponibilidadeId(disp);
		});
		disponibilidadeRepository.removeByProfessorId(professorId);
	}

}
