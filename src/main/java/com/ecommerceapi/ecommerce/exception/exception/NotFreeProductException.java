package com.ecommerceapi.ecommerce.exception.exception;

import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value=HttpStatus.PRECONDITION_FAILED, reason="NOT_FREE_PRODUCT")
public class NotFreeProductException extends AllException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFreeProductException() {
		super(ErrorCode.NOT_FREE_PRODUCT);
	}
}
