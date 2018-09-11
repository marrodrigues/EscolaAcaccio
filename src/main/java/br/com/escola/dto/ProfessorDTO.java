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

@Entity
@Table(name = "Professor")
public class ProfessorDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6425323545568253096L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "professor_id")
	private Integer professorId;
	@Column(name = "nome")
	private String nome;
	@Column(name = "materia")
	private String materia;
	@OneToMany(mappedBy = "professorId", targetEntity = DisponibilidadeDTO.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DisponibilidadeDTO> disponibilidade;

	public Integer getProfessorId() {
		return professorId;
	}
	public void setProfessorId(Integer professorId) {
		this.professorId = professorId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public List<DisponibilidadeDTO> getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(List<DisponibilidadeDTO> disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}