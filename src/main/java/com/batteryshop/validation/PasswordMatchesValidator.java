package com.batteryshop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {

//        if (object instanceof UserEntity entity) {
//
//            return entity.getPassword().equals(entity.getConfirmPassword());
//        }
        return false;
    }

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }
}
