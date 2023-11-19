package Reflection;

import DesignPattern.SingletonTest;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *  获取反射的三种方法
 **/

public class AcquireReflaction {

    public static void main(String[] args) throws ClassNotFoundException {

//        //一、通过反射获取类的CLass对象
//        Class<?> c1 = Class.forName("Reflection.User");
//        System.out.println(c1);
//
//        //获取c1构造器
//        try {
//
//            Constructor< ? > constructor = c1.getConstructor(String.class, int.class);
//            System.out.println("获取c1全部参数构造器：" + constructor);
//
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//
//        // 一个类在内存中只有一个class对象
//        // 一个类敲加载后 的整个结构都会被封装在CLass 对象中
//        Class<?> c2 = Class.forName("Reflection.User");
//        Class<?> c3 = Class.forName("Reflection.User");
//        Class<?> c4 = Class.forName("Reflection.User");
//
//        System.out.println("c2:" + c2.hashCode());
//        System.out.println("c3:" + c3.hashCode());
//        System.out.println("c4:" + c4.hashCode());
//
//
//        //二、Object.getClass();
//        // .getClass()方法获取的Class和反射获取类的CLass对象
//        User user = new User("lucy", 11);
//        Class<? extends User> c5 = user.getClass();
//        System.out.println(c5);
//        System.out.println("c5:" + c5.hashCode());
//
//        //三、User.class
//        Class<User> c6 = User.class;
//        System.out.println("c6:" + c6.hashCode());
//
//        //四、基本内置类型的包装类都有一个TYPE属性
//        Class<Integer> ingegerClass = Integer.TYPE;
//        System.out.println("c7:" +ingegerClass);
//        System.out.println("c8:" +ingegerClass.hashCode());
//
//        //只要元素类型与纬度一样，就是同一个Class
//        Integer[] integer10 = new Integer[10];
//        Integer[] integer100 = new Integer[100];
//        System.out.println("c9:" +integer10.getClass().hashCode());
//        System.out.println("c10:" +integer100.getClass().hashCode());



        SingletonTest singletonTest = new SingletonTest();
        singletonTest.getClass();

        Class<SingletonTest> singletonTestClass = SingletonTest.class;


        try {
            Class<?> aClass = Class.forName("DesignPattern.SingletonTest");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            SingletonTest singletonTest1 = singletonTestClass.newInstance();

            Arrays.stream(singletonTestClass.getMethods()).forEach(System.out::println);


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

@Data
@AllArgsConstructor
class User implements Serializable {

    /** 名称 */
    private String name;

    /** 年龄 */
    private int age;


}
