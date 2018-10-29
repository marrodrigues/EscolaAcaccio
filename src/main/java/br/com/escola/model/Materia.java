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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
@Table(name = "Materia")
public class Materia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6328051596981578050L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "materia_id")
	private Integer materiaId;
	@Column(name = "codigo_materia", nullable = false)
	private String codigo;
	@JsonIgnore
	@OneToMany(mappedBy = "materiaId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Professor> professores;
	@Column(name = "materia", nullable = false)
	private String materia;
	@Column(name = "tempo", nullable = false)
	private Integer tempo;
	@JsonIgnore
	@ManyToMany(mappedBy = "materias")
	private List<Turma> turmas;
}
