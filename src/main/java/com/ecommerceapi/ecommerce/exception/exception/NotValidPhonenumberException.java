package com.ecommerceapi.ecommerce.exception.exception;


import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="NOT_VALID_PHONENUMBER")
public class NotValidPhonenumberException extends AllException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotValidPhonenumberException() {
		super(ErrorCode.NOT_VALID_PHONENUMBER);
	}
}
