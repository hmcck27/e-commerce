package com.ecommerceapi.ecommerce.validation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // 1
@Retention(RetentionPolicy.RUNTIME) // 2
@Constraint(validatedBy = PhoneNumberValidator.class) // 3
public @interface PhoneNumberConstraint {
    String message() default "잘못된 전화번호 형식입니다."; // 4
    Class[] groups() default {};
    Class[] payload() default {};
}


