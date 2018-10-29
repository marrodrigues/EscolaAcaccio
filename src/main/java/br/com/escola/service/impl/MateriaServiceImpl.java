package br.com.escola.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escola.model.Materia;
import br.com.escola.repository.MateriaRepository;
import br.com.escola.service.MateriaService;

@Service
public class MateriaServiceImpl implements MateriaService{

	@Autowired
	private MateriaRepository materiaRepository;
	
	@Override
	public List<Materia> getAll() {
		return materiaRepository.findAll();
	}

	@Override
	public Materia findById(Integer materiaId) {
		return materiaRepository.findByMateriaId(materiaId);
	}
	
	@Override
	public Materia save(Materia materia) {
		Materia findByMateria = materiaRepository.findByCodigo(materia.getCodigo());
		if(!Objects.isNull(findByMateria) && findByMateria.getCodigo().equals(materia.getCodigo())) {
			materia.setMateriaId(findByMateria.getMateriaId());
		}
		materia = materiaRepository.save(materia);
		return materia;
	}
	
}
