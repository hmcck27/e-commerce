package com.ecommerceapi.ecommerce.exception.exception;


import com.ecommerceapi.ecommerce.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason = "KAKAO_ALARM_TALK_SEND_ERROR")
public class KakaoAlarmTalkSendErrorException extends AllException{

    private static final long serialVersionUID = 1L;

    public KakaoAlarmTalkSendErrorException() {
        super(ErrorCode.KAKAO_ALARM_TALK_SEND_ERROR);
    }


}
