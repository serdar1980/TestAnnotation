package ru.serdar1980.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxLengthConstraintValidator implements ConstraintValidator<MaxLength, String> {
    private int annotationMaxLength;
    private String fieldName;

    @Override
    public void initialize(MaxLength constraintAnnotation) {
        annotationMaxLength = constraintAnnotation.maxLength();
        fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context
                .buildConstraintViolationWithTemplate("MaxLength:" + annotationMaxLength + " fieldName:" + fieldName)
                .addConstraintViolation();
        if (value == null) {
            return false;
        }
        return value.length() < annotationMaxLength;
    }
}
