package br.com.escola.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.model.Disponibilidade;
import br.com.escola.model.Professor;

public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Long>{
	
	@Transactional
	void removeByProfessorId (Professor professorId);
	
}
