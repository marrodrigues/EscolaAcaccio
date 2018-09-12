package br.com.escola.model.enumeration;

public enum DiaSemanaEnum {

	Domingo(0), 
	Segunda(1),
	Terça(2),
	Quarta(3),
	Quinta(4),
	Sexta(5),
	Sabado(6),
	Indefinido(99);
	
	private Integer dia;
	
	private DiaSemanaEnum(Integer dia){
		this.dia = dia;
	}
	
	public static DiaSemanaEnum SelecaoDia (Integer dia) {
		for(DiaSemanaEnum diaSemana : DiaSemanaEnum.values()) {
			if(diaSemana.getDia()==dia) return diaSemana;
		}
		return DiaSemanaEnum.Indefinido;
	}

	public Integer getDia() {
		return dia;
	}
	
	
}
