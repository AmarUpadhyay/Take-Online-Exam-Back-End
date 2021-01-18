package com.capgemini.toe.exception;

public class QuestionNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	String message;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}
