package com.proyectonu1.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Exception extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7490789527015791954L;
	
	public Exception(String message) {
		super(message);
	}

}
