package com.ecommerceapi.ecommerce.exception;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorResponse {

	private int status;
    private String message;
    private String code;
    private Map<String, String> validation;
    
    public ErrorResponse() {
    }

    static public ErrorResponse create() {
        return new ErrorResponse();
    }

    public ErrorResponse code(String code) {
        this.code = code;
        return this;
    }

    public ErrorResponse status(int status) {
        this.status = status;
        return this;
    }

    public ErrorResponse message(String message) {
        this.message = message;
        return this;
    }

    public ErrorResponse validations(Map<String, String> validationErrors) {
        this.validation = validationErrors;
        return this;
    }

    public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}

    public Map<String, String> getValidation() {
        return validation;
    }

    
}
