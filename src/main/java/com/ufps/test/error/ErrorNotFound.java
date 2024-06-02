package com.ufps.test.error;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorNotFound extends RuntimeException {

	public ErrorNotFound(String message) {
		super(message);
	}
}
