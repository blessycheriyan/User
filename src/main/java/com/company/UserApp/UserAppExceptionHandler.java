package com.company.UserApp;

import java.util.HashMap;
import java.util.Map;
import java.util.MissingFormatArgumentException;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAppExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentsNotValidException(MethodArgumentNotValidException exp) {
		final Map<String, String> errorDetails = new HashMap();
		exp.getBindingResult().getFieldErrors()
				.forEach(err -> errorDetails.put(err.getField(), err.getDefaultMessage()));

		return errorDetails;

	}

	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Map<String, String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exp) {
		final Map<String, String> errorDetails = new HashMap();
		errorDetails.put("errroMessage", exp.toString());
		return errorDetails;

	}
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(MissingFormatArgumentException.class)
	public Map<String,String>handleMissingFormatArgumentException(MissingFormatArgumentException exp){
		final Map<String,String> errorDetails =new HashMap();
		errorDetails.put("errorMessage", exp.toString());
		return errorDetails;
		
	}
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RuntimeException.class)
	public Map<String,String>handleRuntimeException(RuntimeException exp){
		final Map<String,String> errorDetails =new HashMap();
		errorDetails.put("errorMessage", exp.toString());
		return errorDetails;
		
	}

}
