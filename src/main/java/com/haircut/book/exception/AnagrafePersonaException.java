package com.haircut.book.exception;

public class AnagrafePersonaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AnagrafePersonaException(String error) {
		super(error);
	}
	public AnagrafePersonaException(String error,Throwable a) {
		super(error,a);
	}

}
