package com.zhao.Reflection;


import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @description 通过反射获取所有标有指定注解的方法信息
 * @version 1.0.0
 * @author 通义千问
 * @date 2023/11/24
 * @see
 */
public class GetAllAnotaionMethodsInfoByReflection {

    @MyAnnotation(name="main", value=0)
    public static void main(String[] args) { // 主函数
        // 创建一个新的Reflections对象，参数是你想要扫描的包名
        Reflections reflections = new Reflections("com.zhao.Reflection");

        // 使用getMethodsAnnotatedWith方法获取所有标注了指定注解类型的方法
        Set<Method> annotatedMethods = reflections.getMethodsAnnotatedWith(MyAnnotation.class);

        // 遍历并打印出所有找到的方法
        for (Method method : annotatedMethods) {
            System.out.println(method);
        }

    }
}
