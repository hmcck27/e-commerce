package com.ecommerceapi.ecommerce.exception.exception;


import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="NOT_IAMPORT_ACCESS")
public class NotIamportAccessException extends AllException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotIamportAccessException() {
		super(ErrorCode.NOT_IAMPORT_ACCESS);
	}
}
