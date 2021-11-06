package com.ecommerceapi.ecommerce.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidationValidator implements ConstraintValidator<DateValidation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String pattern = "^[0-9][0-9][0-9][0-9]\\-[0-9][0-9]\\-[0-9][0-9]$";
        if (!value.matches(pattern)) {// (년도-월-일) 의 패턴으로 넘어오는지 체크
            return false;
        } else {
            return true;
        }
    }

}
