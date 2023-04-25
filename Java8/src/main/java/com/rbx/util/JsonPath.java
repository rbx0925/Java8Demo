package com.rbx.util;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
@Documented
public @interface JsonPath {
    String value() default "";
}
