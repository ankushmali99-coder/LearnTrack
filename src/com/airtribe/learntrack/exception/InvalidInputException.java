package com.airtribe.learntrack.exception;

public class InvalidInputException extends RuntimeException{
	
	//for review
	public InvalidInputException() {
		super("Please enter valid input: ");  // message passed to RuntimeException
	}

}
