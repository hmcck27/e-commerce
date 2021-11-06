package com.ecommerceapi.ecommerce.exception.exception;


import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "NOT_VALID_REFRESH_TOKEN")
public class NotValidRefreshTokenException extends AllException {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotValidRefreshTokenException() {
		super(ErrorCode.NOT_VALID_REFRESH_TOKEN);
		// TODO Auto-generated constructor stub
	}

}
