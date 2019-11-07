package com.zy.zy_sso.entity;

/**
 * @program: SpringCloud
 * @description: 自定义注解
 * @author: zhang yi
 * @create: 2019-11-07 14:50
 */
import java.lang.annotation.*;

/**
 *  * @Description 用于配置实体类字段说明信息
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Com {

    String name() default "";
}

