package br.com.escola.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Professor")
@Data
public class ProfessorDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6425323545568253096L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "professor_id")
	private Integer professorId;
	@Column(name = "cpf", nullable = false)
	private String cpf;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "materia", nullable = false)
	private String materia;
	@OneToMany(mappedBy = "professorId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DisponibilidadeDTO> disponibilidade;
	
}