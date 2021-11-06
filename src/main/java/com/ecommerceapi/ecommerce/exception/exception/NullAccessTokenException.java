package com.ecommerceapi.ecommerce.exception.exception;

import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="NULL_ACCESS_TOKEN")
public class NullAccessTokenException extends AllException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullAccessTokenException() {
		super(ErrorCode.NULL_ACCESS_TOKEN);
	}
}
