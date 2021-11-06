package com.ecommerceapi.ecommerce.response;

import com.ecommerceapi.ecommerce.controller.UserTokenMap;
import com.ecommerceapi.ecommerce.dto.UserProfileDto;
import lombok.Data;

@Data
public class UserApiResponse<E>{

    private E userRelatedDto;

    public UserApiResponse(E userRelatedDto) {
        this.userRelatedDto = userRelatedDto;
    }

}
