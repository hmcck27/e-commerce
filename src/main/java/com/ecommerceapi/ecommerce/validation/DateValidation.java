package com.ecommerceapi.ecommerce.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateValidation {
    String message() default "제대로 된 날짜인지 검증합니다."; // 4
    Class[] groups() default {};
    Class[] payload() default {};
}
