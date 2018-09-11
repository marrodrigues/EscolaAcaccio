package br.com.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.dto.ProfessorDTO;

public interface ProfessorRepository extends JpaRepository<ProfessorDTO, Long>{

}
