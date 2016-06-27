package org.demo.wzs.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 *
 *自定义validate注解
 *
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Validate {

    public ValidateTypeKind type();

    public String name();

    public boolean required() default false;

    public int maxLength() default 0;

}
