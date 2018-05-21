package com.py4j.demospringboot.application.annotaion;

import com.py4j.demospringboot.application.validator.KeyWordForbidden;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = KeyWordForbidden.class)
public @interface KeyWordValidator {

    String[] values();

    String message() default "include sensitive word";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
