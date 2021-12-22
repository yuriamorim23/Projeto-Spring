package com.projetojava.cursomc.services.exception;

public class ObjectNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
