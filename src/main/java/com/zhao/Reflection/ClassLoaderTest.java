package com.zhao.Reflection;

/**
 * 类加载过程
 **/
public class ClassLoaderTest {

        /**
         * *
         * 1: 加截到内存 ，会产生一个类对应class对象
         * 2: 链接 ，链接结束后 m = 0
         * 3：初始化 构造实例对象
                 <clinit>(){
                         system.out.printIn("A美静态代码块初始化");
                         m = 300;
                         m = 100;
                  }
         */
//        public static void main(String[] args) {
//            A a = new A();
//            System.out.println(A.m);
//        }

    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器-->根加载器(c/c++)  - 获取不到
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);



        //测试当前类是哪个加载器加载的【app加载器】
        ClassLoader classLoader = Class.forName("com.zhao.Reflection.A").getClassLoader();
        System.out.println("自定义类A 加载器：" + classLoader);

        //测试jdk内置类是哪个加载器加载的【根加载器(c/c++)】
        ClassLoader jdkLoader = Class.forName("java.lang.reflect.Array").getClassLoader();
        System.out.println("jdk中Array 加载器：" + jdkLoader);


        System.out.println(System.getProperty("java.class.path"));
        /**
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\charsets.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\deploy.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\ext\access-bridge-64.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\ext\cldrdata.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\ext\dnsns.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\ext\jaccess.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\ext\jfxrt.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\ext\localedata.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\ext\nashorn.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\ext\sunec.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\ext\sunjce_provider.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\ext\sunmscapi.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\ext\sunpkcs11.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\ext\zipfs.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\javaws.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\jce.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\jfr.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\jfxswt.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\jsse.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\management-agent.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\plugin.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\resources.jar;
         * C:\Program Files\Java\jdk1.8.0_77\jre\lib\rt.jar;
         * D:\CODE\Gitee\WebStudy\ThreadTest\target\test-classes;
         * D:\CODE\Gitee\WebStudy\ThreadTest\target\classes;
         * D:\soft\application\apache-maven-3.6.3\LocalRepo\org\projectlombok\lombok\1.18.20\lombok-1.18.20.jar;
         * D:\soft\application\IDEA\IntelliJ IDEA 2021.3.2\lib\idea_rt.jar
         */

    }

}

class A {
    static int m = 100;

    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }

    public A() {
        System.out.println("A类的无参构造初始化");
    }
}