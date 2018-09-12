package br.com.escola.model;

import java.io.Serializable;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.escola.model.enumeration.CreditoEnum;
import br.com.escola.model.enumeration.DiaSemanaEnum;
import lombok.Data;

@Entity
@Table(name = "Disponibilidade")
@Data
public class Disponibilidade implements Serializable{
	
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
	private Professor professorId;
	@Column(name = "dia")
	@Enumerated(EnumType.ORDINAL)
	private DiaSemanaEnum dia;
	@Column(name = "tempo")
	@Enumerated(EnumType.ORDINAL)
	private CreditoEnum tempo;
	
}
