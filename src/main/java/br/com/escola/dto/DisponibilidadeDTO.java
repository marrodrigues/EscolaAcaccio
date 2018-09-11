package br.com.escola.dto;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.escola.dto.enumeration.DiaSemanaEnum;

@Entity
@Table(name = "Disponibilidade")
public class DisponibilidadeDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1118288507077198793L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "disponibilidade_id")
	private Integer disponibilidadeId;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", nullable = false)
	private ProfessorDTO professorId;
	@Column(name = "dia")
	@Enumerated(EnumType.ORDINAL)
	private DiaSemanaEnum dia;
	@Column(name = "hora_inicio")
	private LocalTime horaInicio;
	@Column(name = "hora_final")
	private LocalTime horaFinal;
	
	public Integer getDisponibilidadeId() {
		return disponibilidadeId;
	}
	public void setDisponibilidadeId(Integer disponibilidadeId) {
		this.disponibilidadeId = disponibilidadeId;
	}
	public ProfessorDTO getProfessorId() {
		return professorId;
	}
	public void setProfessorId(ProfessorDTO professorId) {
		this.professorId = professorId;
	}
	public DiaSemanaEnum getDia() {
		return dia;
	}
	public void setDia(DiaSemanaEnum dia) {
		this.dia = dia;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalTime getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
