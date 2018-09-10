package br.com.escola.dto;

import lombok.Data;

@Data
public class ProfessorDTO {

	private Integer id;
	private String nome;
	private String materia;
	private DisponibilidadeDTO disponibilidade;
	
}
