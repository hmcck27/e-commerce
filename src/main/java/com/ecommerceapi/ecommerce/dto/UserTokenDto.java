package com.ecommerceapi.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserTokenDto {

    private String accessToken;
    private String refreshToken;

    @Builder
    public UserTokenDto(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
