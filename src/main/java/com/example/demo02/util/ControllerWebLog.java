package com.example.demo02.util;

/**
 * @author Li Ning
 * @version 1.0
 * @date 2020/12/14 0014 11:04
 * description : 自定义注解，用于controller 中的 标记值
 */

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    String name();  //所调用接口的名称
    boolean intoDb() default false;  //标识该条操作日志是否需要持久化存储
}
