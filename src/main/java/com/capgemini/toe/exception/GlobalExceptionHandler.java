package com.capgemini.toe.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(TestDoesNotExistException.class)
	public ResponseEntity<?> resourceNotFoundException(TestDoesNotExistException ex, WebRequest request) {
		ex.setMessage("Test with this id does not exist try different test id");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CandidateDoesNotExistException.class)
	public ResponseEntity<?>CandidateNotFoundException(CandidateDoesNotExistException ex, WebRequest request) {
		ex.setMessage("Candidate with this user id does not exist try different user id");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(QuestionNotFoundException.class)
	public ResponseEntity<?>QuestionNotFoundException(QuestionNotFoundException ex, WebRequest request) {
		ex.setMessage("Question with this QuestionId does not exist try different QuestionId");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(QuestionBankEmptyException.class)
	public ResponseEntity<?>QuestionBankEmptyException(QuestionBankEmptyException ex, WebRequest request) {
		ex.setMessage("QuestionBank is Yet to Add By an Instructor");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(LoginError.class)
	public ResponseEntity<?> resourceNotFoundException(LoginError ex, WebRequest request) {
		ex.setMessage("Wrong Email or password Login Again");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
