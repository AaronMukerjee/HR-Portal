package com.hruser.main.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hruser.main.constants.ResponseMessages;
import com.hruser.main.exceptions.UserNotFoundException;
import com.hruser.main.response.APIResponse;

@RestControllerAdvice
public class ExceptionHandlingAdvice {

	@ExceptionHandler(UserNotFoundException.class)
	public APIResponse<String> userNotFound(UserNotFoundException ex){
		APIResponse<String> response = new APIResponse<>();
		response.code=HttpStatus.BAD_REQUEST;
		response.responseMessage=ResponseMessages.USER_NOT_FOUND;
		return response;
	}
	@ExceptionHandler(Exception.class)
	public APIResponse<String> handleException(Exception ex){
		APIResponse<String> response = new APIResponse<>();
		response.code=HttpStatus.INTERNAL_SERVER_ERROR;
		response.responseMessage=ex.getMessage();
		return response;
	}
}
