package com.credit.usuario.domain.exceptions;

public class DadoDuplicadoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DadoDuplicadoException(String msg) {
		super(msg);
	}

}
