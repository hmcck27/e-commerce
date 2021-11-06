package com.ecommerceapi.ecommerce.exception.exception;


import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason = "NOT_EXIST_USER")
public class NotExistUserException extends AllException{

	private static final long serialVersionUID = 1L;
	public NotExistUserException() {
		super(ErrorCode.NOT_EXIST_USER);
	}
	
}
