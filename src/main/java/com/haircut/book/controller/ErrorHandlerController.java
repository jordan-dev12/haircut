package com.haircut.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.haircut.book.vm.ErrorVm;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ErrorHandlerController {
	
	private static String NOT_VALID_EXCEPTION = "ERRORE VALIDATION - ";

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorVm handleInvalidArgument(MethodArgumentNotValidException ex, WebRequest request) {
		log.error(NOT_VALID_EXCEPTION  + ex.getMessage(), ex);
		return ErrorVm.builder().descrizione(request.getDescription(false)).message(ex.getMessage())
				.statusCode(HttpStatus.BAD_REQUEST.value()).build();

	}
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorVm handleException(Exception ex, WebRequest request) {
		log.error(NOT_VALID_EXCEPTION  + ex.getMessage(), ex);
		return ErrorVm.builder().descrizione(request.getDescription(false)).message(ex.getMessage())
				.statusCode(HttpStatus.BAD_REQUEST.value()).build();
		
	}


}
