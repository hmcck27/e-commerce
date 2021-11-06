package com.ecommerceapi.ecommerce.exception.exception;


import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="PDF_WATERMARK_ERROR")
public class PdfWatermarkErrorException extends AllException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PdfWatermarkErrorException() {
		super(ErrorCode.PDF_WATERMARK_ERROR);
	}
}
