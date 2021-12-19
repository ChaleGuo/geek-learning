package com.example.exercise.week7.mydds.config;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDs {
    /**
     * 数据源名称
     */
    String value() default DsKey.MASTER;
}
