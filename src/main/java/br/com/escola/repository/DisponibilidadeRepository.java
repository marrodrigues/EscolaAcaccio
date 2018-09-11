package br.com.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.dto.DisponibilidadeDTO;

public interface DisponibilidadeRepository extends JpaRepository<DisponibilidadeDTO, Long>{

}
