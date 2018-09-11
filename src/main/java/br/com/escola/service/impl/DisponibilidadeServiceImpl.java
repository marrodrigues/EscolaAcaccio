package br.com.escola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escola.dto.DisponibilidadeDTO;
import br.com.escola.repository.DisponibilidadeRepository;
import br.com.escola.service.DisponibilidadeService;

@Service
public class DisponibilidadeServiceImpl implements DisponibilidadeService {

	@Autowired
	private DisponibilidadeRepository disponibilidadeRepository;

	@Override
	public DisponibilidadeDTO save(DisponibilidadeDTO dia) {
		findAll().forEach(diaSalvo -> {
			if (dia.getDia().equals(diaSalvo.getDia())) {
				dia.setDisponibilidadeId(diaSalvo.getDisponibilidadeId());
			}
		});
		return disponibilidadeRepository.save(dia);
	}

	@Override
	public List<DisponibilidadeDTO> findAll() {
		return disponibilidadeRepository.findAll();
	}
	
}
