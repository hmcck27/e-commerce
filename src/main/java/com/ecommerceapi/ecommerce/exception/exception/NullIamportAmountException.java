package com.ecommerceapi.ecommerce.exception.exception;


import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="NULL_IAMPORT_AMOUNT")
public class NullIamportAmountException extends AllException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullIamportAmountException() {
		super(ErrorCode.NULL_IAMPORT_AMOUNT);
	}
}
