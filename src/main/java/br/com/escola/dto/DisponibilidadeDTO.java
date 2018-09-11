package br.com.escola.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.escola.dto.enumeration.DiaSemanaEnum;

@Entity
@Table(name = "Disponibilidade")
public class DisponibilidadeDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1118288507077198793L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "disponibilidade_id")
	private Integer disponibilidadeId;
	@ManyToOne(optional = false, targetEntity = ProfessorDTO.class)
	@JoinColumn(name = "professor_id")
	private Integer professorId;
	@Column(name = "dia")
	@Enumerated(EnumType.STRING)
	private DiaSemanaEnum dia;
	@Column(name = "hora_inicio")
	private Date horaInicio;
	@Column(name = "hora_final")
	private Date horaFinal;
	
	public Integer getDisponibilidadeId() {
		return disponibilidadeId;
	}
	public void setDisponibilidadeId(Integer disponibilidadeId) {
		this.disponibilidadeId = disponibilidadeId;
	}
	public long getProfessorId() {
		return professorId;
	}
	public void setProfessorId(Integer professorId) {
		this.professorId = professorId;
	}
	public DiaSemanaEnum getDia() {
		return dia;
	}
	public void setDia(DiaSemanaEnum dia) {
		this.dia = dia;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
