package br.com.escola.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.model.Disponibilidade;
import br.com.escola.model.Periodo;

public interface PeriodoRepository extends JpaRepository<Periodo, Long>{
	
	@Transactional
	void removeByDisponibilidadeId(Disponibilidade disponibilidade);
}
