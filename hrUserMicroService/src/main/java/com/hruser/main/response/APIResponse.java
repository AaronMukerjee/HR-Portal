package com.hruser.main.response;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public  class APIResponse<T> {

	public  HttpStatus code ;
	public  String responseMessage;
	public T ResponseObject;
}
