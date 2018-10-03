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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "Professor")
@Data
public class Professor implements Serializable {
	
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
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materia_id", nullable = false)
	private Materia materiaId;
	@Column(name = "disponibilidade", nullable = false)
	@OneToMany(mappedBy = "professorId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Disponibilidade> disponibilidade;
	
}