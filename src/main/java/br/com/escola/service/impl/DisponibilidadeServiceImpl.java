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
				if (dia.getHoraInicio().equals(diaSalvo.getHoraInicio())
						&& dia.getHoraFinal().equals(diaSalvo.getHoraFinal())) {
					dia.setDisponibilidadeId(diaSalvo.getDisponibilidadeId());
				} else {
					if(dia.getHoraInicio().compareTo(diaSalvo.getHoraInicio()) < 0) dia.setHoraInicio(diaSalvo.getHoraInicio());
					if(dia.getHoraFinal().compareTo(diaSalvo.getHoraInicio()) > 0) dia.setHoraFinal(diaSalvo.getHoraFinal());
				}
			}
		});
		return disponibilidadeRepository.save(dia);
	}

	@Override
	public List<DisponibilidadeDTO> findAll() {
		return disponibilidadeRepository.findAll();
	}

}
