package Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * （注：系统名称 - 模块名称 - 功能名称）
 * Copyright 1998-2023 company dept
 * @author zhaoYI 2023-11-19 15:45
 * @version 0.1
 * @date 2023-11-19（注：最后更新日期）
 * Modification History:
 *    Date         Author       Version     Description
 * ****************************************************
 *  2023-11-19   zhaoYI       0.1         初始开发
 **/

public class Generics {

    public void showName(Map<String, User> map, List<User> list){
        System.out.println("SHOW NAME");
    }

    public void showName(int age){
        System.out.println(age);
    }

    /**
     * 通过反射获取具体参数类型
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        //获取映射类型
        //Class<?> genericsClass = Class.forName("Reflection.Generics");
        //Class<Generics> genericsClass = Generics.class;
        Generics generics = new Generics();
        Class<? extends Generics> genericsClass = generics.getClass();

        //通过反射获取指定方法
        Method showNameMethods = genericsClass.getMethod("showName", Map.class, List.class);
        //获取-通用参数-集合
        Type[] genericParameterTypes = showNameMethods.getGenericParameterTypes();

        for (Type genericParameterType: genericParameterTypes){
            //通用集合中的参数类别
            System.out.println("genericParameterTypes: "+ genericParameterType);

            if(genericParameterType instanceof ParameterizedType) {
                //获取-实际参数类别集合
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();

                for (Type actualTypeArgument : actualTypeArguments){
                    System.out.println(actualTypeArgument);
                }
            }
        }

    }
}
