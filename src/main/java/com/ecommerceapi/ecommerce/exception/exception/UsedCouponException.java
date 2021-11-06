package com.ecommerceapi.ecommerce.exception.exception;


import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.PRECONDITION_FAILED, reason = "ALREADY_USED_COUPON")
public class UsedCouponException extends AllException{
	
	private static final long serialVersionUID = 1L;
	
	public UsedCouponException() {
		super(ErrorCode.ALREADY_USED_COUPON);
	}
}
