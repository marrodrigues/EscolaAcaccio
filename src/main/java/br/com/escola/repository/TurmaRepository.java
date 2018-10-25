package br.com.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{

	Turma findByCodigo(String codigo);

}
