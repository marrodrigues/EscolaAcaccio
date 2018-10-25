package br.com.escola.service.exception;

public class MinDisponibilidadeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1238850975495071897L;

	public MinDisponibilidadeException () {
		super();
	}
	
	public MinDisponibilidadeException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public MinDisponibilidadeException (String message) {
		super(message);
	}
	
	public MinDisponibilidadeException (Throwable cause) {
		super(cause);
	}
	
}
