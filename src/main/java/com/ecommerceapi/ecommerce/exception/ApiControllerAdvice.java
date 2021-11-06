package com.ecommerceapi.ecommerce.exception;

import com.ecommerceapi.ecommerce.exception.exception.AllException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors()
                .forEach(c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));

        final ErrorResponse response = ErrorResponse
                .create()
                .status(ErrorCode.BAD_REQUEST.getStatus())
                .code(ErrorCode.BAD_REQUEST.getCode())
                .validations(
                        errors);

        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCode.BAD_REQUEST.getStatus()));
    }

    @ExceptionHandler(AllException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(AllException e) {

        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse
                .create()
                .status(errorCode.getStatus())
                .code(errorCode.getCode())
                .message(errorCode.getMessage());

        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }
}
