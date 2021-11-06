package com.ecommerceapi.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter @Setter
public class SimpleUserVerifyDto {

    @NotNull(message = "userId는 비어서는 안됩니다.")
    private String userId;

    @NotNull(message = "plaformType은 비어있어어서는 안됩니다.")
    private String userPlatformType;

    @NotNull(message = "platformId는 비어있어서는 안됩니다.")
    private String userPlatformId;
}
