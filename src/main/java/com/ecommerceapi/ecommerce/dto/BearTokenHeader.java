package com.ecommerceapi.ecommerce.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BearTokenHeader {

    @NotNull
    public String authorization;

    public String getAccessToken() {
        return authorization.split(" ")[1];
    }

}
