package com.ecommerceapi.ecommerce.dto.user;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserSignInDto {

    @NotNull
    private String providerType;

    @NotNull
    private String providerId;

    @Builder
    private UserSignInDto(String providerType, String providerId) {
        this.providerType = providerType;
        this.providerId = providerId;
    }

}
