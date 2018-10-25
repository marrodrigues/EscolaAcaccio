package br.com.escola.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escola.model.Turma;
import br.com.escola.repository.TurmaRepository;
import br.com.escola.service.TurmaService;

@Service
public class TurmaServiceImpl implements TurmaService{

	@Autowired
	private TurmaRepository turmaRepository;
	
	@Override
	public List<Turma> getAll() {
		return turmaRepository.findAll();
	}

	@Override
	public Turma findByCodigo(String codigo) {
		return turmaRepository.findByCodigo(codigo);
	}

	@Override
	public Turma save(Turma turma) {
		
		Turma findByCodigo = turmaRepository.findByCodigo(turma.getCodigo());
		
		if(!Objects.isNull(findByCodigo) && findByCodigo.getCodigo().equals(turma.getCodigo())) {
			turma.setTurmaId(findByCodigo.getTurmaId());
		}
		
		return turmaRepository.save(turma);
	}
	
}
