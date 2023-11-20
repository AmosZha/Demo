package Reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * （注：系统名称 - 模块名称 - 功能名称）
 * Copyright 1998-2023 company dept
 * @author zhaoYI 2023-11-21 00:22
 * @version 0.1
 * @date 2023-11-21（注：最后更新日期）
 * Modification History:
 *    Date         Author       Version     Description
 * ****************************************************
 *  2023-11-21   zhaoYI       0.1         初始开发
 **/

public class GetAnotaionInfo {

    public static void main(String[] args) {
        Class<MyClass> clazz = MyClass.class;
        MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.name()); // 输出 "example"
        System.out.println(annotation.value()); // 输出 10
    }
}


/**
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotation {
    String name();
    int value();
}

/**
 * 注解类
 */
@MyAnnotation(name="example", value=10)
class MyClass {
    // ...
}