package com.ecommerceapi.ecommerce.exception.exception;


import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.PRECONDITION_FAILED, reason = "DIFFERENT_AMOUNT_SALEPRICE")
public class DifferentAmountSalepriceException extends AllException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DifferentAmountSalepriceException() {
		super(ErrorCode.DIFFERENT_AMOUNT_SALEPRICE);
	}
	
}
