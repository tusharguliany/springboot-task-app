package com.guliany.app.config;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.guliany.app.dto.ResponseDTO;
import com.guliany.app.exception.AppException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerConfig {

	@ExceptionHandler(value = {MethodArgumentNotValidException.class, AppException.class})
	public ResponseEntity<?> handleKnownErrors(Exception ex) {
		log.trace("handleKnownErrors called in ExceptionHandlerConfig");
		log.error("Known Error Encountered");
		String errorMessage = ex.getMessage();
		ResponseDTO dto = new ResponseDTO();
		dto.setError(errorMessage);
		dto.setTime(LocalDateTime.now());
		dto.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
	}

}
