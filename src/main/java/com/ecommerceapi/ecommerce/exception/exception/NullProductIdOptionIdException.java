package com.ecommerceapi.ecommerce.exception.exception;

import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="NULL_PRODUCTID_OPTIONID")
public class NullProductIdOptionIdException extends AllException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullProductIdOptionIdException() {
		super(ErrorCode.NULL_PRODUCTID_OPTIONID);
	}
}
