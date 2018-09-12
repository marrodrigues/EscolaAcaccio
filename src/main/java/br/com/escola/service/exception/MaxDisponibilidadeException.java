package br.com.escola.service.exception;

public class MaxDisponibilidadeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1238850975495071897L;

	public MaxDisponibilidadeException () {
		super();
	}
	
	public MaxDisponibilidadeException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public MaxDisponibilidadeException (String message) {
		super(message);
	}
	
	public MaxDisponibilidadeException (Throwable cause) {
		super(cause);
	}
	
}
