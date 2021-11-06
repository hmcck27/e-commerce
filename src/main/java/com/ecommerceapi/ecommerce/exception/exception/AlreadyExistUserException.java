package com.ecommerceapi.ecommerce.exception.exception;


import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.PRECONDITION_FAILED, reason="ALREADY_EXIST_USER")
public class AlreadyExistUserException extends AllException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AlreadyExistUserException() {
		super(ErrorCode.ALREADY_EXIST_USER);
	}
}
