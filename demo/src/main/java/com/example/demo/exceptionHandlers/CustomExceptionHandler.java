package com.example.demo.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.NoResultException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Map<String, String>> handleNullPointerException(NullPointerException ex) {
		Map<String, String> resp = new HashMap<>();
		resp.put("error", "NullPointerException occurred");
		return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public ResponseEntity<Map<String, String>> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex) {
		Map<String, String> resp = new HashMap<>();
		resp.put("error", "ArrayIndexOutOfBoundsException occurred");
		return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(NoResultException.class)
	public ResponseEntity<Map<String, String>> handleResourceNotFoundException(NoResultException ex) {
		Map<String, String> resp = new HashMap<>();
		resp.put("error", "No data found");
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HttpClientErrorException.NotFound.class)
	public ResponseEntity<Map<String, String>> notFoundException(HttpClientErrorException.NotFound ex) {
		Map<String, String> resp = new HashMap<>();
		resp.put("error", ex.getMessage());
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
		Map<String, String> resp = new HashMap<>();
		resp.put("error", ex.getMessage());
		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}
}
