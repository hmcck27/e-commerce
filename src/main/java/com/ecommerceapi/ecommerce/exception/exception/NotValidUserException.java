package com.ecommerceapi.ecommerce.exception.exception;

import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "NOT_VALID_USER")
public class NotValidUserException extends AllException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotValidUserException() {
		super(ErrorCode.NOT_VALID_USER);
		// TODO Auto-generated constructor stub
	}
}


