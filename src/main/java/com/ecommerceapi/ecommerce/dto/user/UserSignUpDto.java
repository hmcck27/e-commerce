package com.ecommerceapi.ecommerce.dto.user;

import com.ecommerceapi.ecommerce.validation.DateValidation;
import com.ecommerceapi.ecommerce.validation.PhoneNumberConstraint;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class UserSignUpDto {

    @NotNull
    private String providerType;

    @NotNull
    private String providerId;

    @NotNull
    private String name;

    @NotNull
    private String marketingAgreement;

    @NotNull
    private String serviceAgreement;

    @NotNull
    @PhoneNumberConstraint
    private String phoneNumber;

    @Email
    private String email;

    @DateValidation
    private String birth;

}
