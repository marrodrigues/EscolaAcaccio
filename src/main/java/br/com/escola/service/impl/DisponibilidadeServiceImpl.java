package br.com.escola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escola.model.Disponibilidade;
import br.com.escola.model.Professor;
import br.com.escola.repository.DisponibilidadeRepository;
import br.com.escola.service.DisponibilidadeService;

@Service
public class DisponibilidadeServiceImpl implements DisponibilidadeService {

	@Autowired
	private DisponibilidadeRepository disponibilidadeRepository;

	@Override
	public Disponibilidade save(Disponibilidade dia) {
		findAll().forEach(diaSalvo -> {
			if (dia.getDia().equals(diaSalvo.getDia())) {
				if(dia.getTempo().getCodigo().equals(diaSalvo.getTempo().getCodigo())) {
					return;
				}
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
		disponibilidadeRepository.removeByProfessorId(professorId);
	}

}
