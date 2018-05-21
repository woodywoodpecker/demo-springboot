package com.py4j.demospringboot.application.validator;

import com.py4j.demospringboot.application.annotaion.KeyWordValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author Warren
 * @CreateTime 21.May.2018
 * @Version V1.0
 */
public class KeyWordForbidden implements ConstraintValidator<KeyWordValidator,Object> {

    private String[] values;

    @Override
    public void initialize(KeyWordValidator constraintAnnotation) {
        values = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (!(value instanceof String)) {
            return true;
        }
        if (values == null || values.length == 0) {
            return true;
        }
        for (String keyWord : values) {
            String content = (String) value;
            if (content.contains(keyWord)) {
                return false;
            }
        }
        return true;
    }
}
