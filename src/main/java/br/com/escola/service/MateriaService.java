package br.com.escola.service;

import java.util.List;

import br.com.escola.model.Materia;

public interface MateriaService {

	List<Materia> getAll();

	Materia save(Materia materia);

	Materia findById(Integer materiaId);

}
