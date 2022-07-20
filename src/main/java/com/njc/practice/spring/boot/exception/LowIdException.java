package com.njc.practice.spring.boot.exception;

public class LowIdException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5083248735332442024L;

	public LowIdException(String msg) {
		super(msg);
	}

}
