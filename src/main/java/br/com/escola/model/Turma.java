package br.com.escola.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Turma")
@Data
public class Turma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5312479771045694741L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "turma_id")
	private Integer turmaId;
	@Column(name = "creditos")
	private Integer creditos;
	@Column(name = "codigo_turma", nullable = false)
	private String codigo;
	@Column(name = "serie", nullable = false)
	private String serie;
	@ManyToMany
	@JoinTable(name = "turma_materia", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns = @JoinColumn(name = "materia_id"))
	private List<Materia> materias;
	
}
