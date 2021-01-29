package com.csm.demo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidator implements ConstraintValidator<MyAnnotation, Object> {

    @Override
    public void initialize(MyAnnotation myAnnotation) {
        System.out.println("myValidator 初始化");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(!o.equals("csm")){
            return true;
        }
        return false;
    }
}
