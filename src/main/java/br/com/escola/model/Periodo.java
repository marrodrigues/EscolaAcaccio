package br.com.escola.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Periodo")
public class Periodo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4982756512210145111L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "periodoId")
	private Integer periodoId;
	@Column(name = "start")
	private String start;
	@Column(name = "end")
	private String end;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disponibilidade_id", nullable = false)
	private Disponibilidade disponibilidadeId;
	
}
