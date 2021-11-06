package com.ecommerceapi.ecommerce.exception.exception;

import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="BAD_REQEUST")
public class BadRequestException extends AllException{

    private static final long serialVersionUID = 1L;
    public BadRequestException() {
        super(ErrorCode.BAD_REQUEST);
    }

}
