package ru.serdar1980.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MaxLengthConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxLength {
    int maxLength();

    /*
    FieldName against which we validate
    */
    String fieldName();

    String message() default "{MaxLength}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
