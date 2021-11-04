package com.ecommerceapi.ecommerce.dto;

import com.ecommerceapi.ecommerce.validation.PhoneNumberConstraint;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedNotification;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UserSignUpDto {

    @NotNull
    private String snsType;

    @NotNull
    private String snsId;

    @NotNull
    private String name;

    @NotNull
    @PhoneNumberConstraint
    private String phoneNumber;

    @Builder
    public UserSignUpDto(String snsType, String snsId, String name, String phoneNumber) {
        this.snsType = snsType;
        this.snsId = snsId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

}
