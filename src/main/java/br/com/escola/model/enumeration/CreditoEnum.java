package br.com.escola.model.enumeration;

import java.time.LocalTime;

public enum CreditoEnum {

	Primeiro(1,"08:00:00","09:00:00"), 
	Segundo(2,"09:00:00","10:00:00"),
	Terceiro(3,"10:00:00","11:00:00"),
	Quarto(4,"11:00:00","12:00:00"),
	Indefinido(99,"00:00:00","00:00:00");
	
	private Integer codigo;
	private LocalTime horaInicio;
	private LocalTime horaFinal;
	
	private CreditoEnum(Integer codigo, String horaInicio, String horaFinal){
		this.codigo = codigo;
		this.horaInicio = LocalTime.parse(horaInicio);
		this.horaFinal = LocalTime.parse(horaFinal);
	}
	
	public static CreditoEnum SelecaoTempo (Integer codigo) {
		for(CreditoEnum codigoEnum : CreditoEnum.values()) {
			if(codigoEnum.getCodigo()==codigo) return codigoEnum;
		}
		return CreditoEnum.Indefinido;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	
}
