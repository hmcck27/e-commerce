package com.ecommerceapi.ecommerce.exception;
public enum ErrorCode {
    // Common
    NULL_REFRESH_TOKEN(400,"refresh토큰이 없음","NULL_REFRESH_TOKEN"),
    NOT_VALID_REFRESH_TOKEN(400,"refresh토큰이 유효하지 않음","NOT_VALID_REFRESH_TOKEN"),
    NULL_PRODUCTID_OPTIONID(400,"productId 또는 optionId가 없음","NULL_PRODUCTID_OPTIONID"),
    NULL_IMPUID_MERCHANTUID(400,"impUid 또는 merchantUid가 비었음","NULL_IMPUID_MERCHANTUID"),

    NULL_ACCESS_TOKEN(401,"access token이 없음", "NULL_ACCESS_TOKEN"),
    NOT_VALID_ACCESS_TOKEN(401,"access token이 유효하지 않음", "NOT_VALID_ACCESS_TOKEN"),
    BAD_REQUEST(401, "잘못된 request body입니다.", "BAD_REQUEST"),

    NOT_VALID_USER(403, "리소스에 대한 권한이 없음", "NOT_VALID_USER"),
    NOT_VALID_COUPON_CODE(403, "유효하지 않은 코드입니다", "NOT_VALID_COUPON_CODE"),

    DIFFERENT_AMOUNT_SALEPRICE(412,"결제 시도 금액이 실제 상품 금액과 상이합니다.","DIFFERENT_AMOUNT_SALEPRICE"),
    NOT_VALID_MERCHANTUID(412, "merchantUid가 유효하지 않음","NOT_VALID_MERCHANTUID"),
    NOT_FREE_PRODUCT(412, "무료 상품이 아님", "NOT_FREE_PRODUCT"),
    ALREADY_USED_COUPON(412, "이미 사용된 코드입니다", "ALREADY_USED_COUPON"),
    ALREADY_EXIST_USER(412, "이미 존재하는 사용자입니다.", "ALREADY_EXIST_USER"),
    NOT_EXIST_USER(412, "존재하지 않는 사용자입니다.", "NOT_EXIST_USER"),
    NOT_EXIST_PRODUCT(412, "존재하지 않는 상품입니다.", "NOT_EXIST_PRODUCT"),

    NOT_IAMPORT_ACCESS(500, "iamport에서 accessToken은 가져오지 못함","NOT_IAMPORT_ACCESS"),
    NULL_IAMPORT_AMOUNT(500,"iamport에서 amount를 가져오지 못함","NULL_IAMPORT_AMOUNT"),
    NOT_VALID_PHONENUMBER(500, "twilio create error(전화번호가 유효하지 않음)","NOT_VALID_PHONENUMBER"),
    NULL_TWILIO_VERIFICATION(500, "twilio create error(verification이 만들어 지지 않음)", "NULL_TWILIO_VERIFICATION"),
    PDF_WATERMARK_ERROR(500, "PDF 워터마크 삽입 오류", "PDF_WATERMARK_ERROR"),
    KAKAO_ALARM_TALK_SEND_ERROR(500, "카카오 알림 톡 에러", "KAKAO_ALARM_TALK_SEND_ERROR"),

    ;

    private final String code;
    private final String message;
    private final int status;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    ErrorCode(final int status, final String message, final String code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
