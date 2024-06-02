package com.ufps.test.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ufps.test.models.ErrorResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ErrorNotFound.class)
	public ResponseEntity<ErrorResponseDTO> handleMangaNotFoundException(ErrorNotFound ex) {
		ErrorResponseDTO errorResponse = new ErrorResponseDTO(true, ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
