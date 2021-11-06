package com.ecommerceapi.ecommerce.exception.exception;


import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "all exception")
public class AllException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;
		
		public AllException(ErrorCode errorCode) {
			super(errorCode.getMessage());
			this.errorCode = errorCode;
		}
	
		public ErrorCode getErrorCode() {
			return errorCode;
		}
}
