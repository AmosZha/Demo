package com.zhao.Reflection.load;

public class ClassLoadOrder extends B {
    public ClassLoadOrder() {
        super("显示调用父类含参构造，不可缺少！！");
        System.out.println("子类A的构造函数");
    }

    static {
        System.out.println("子类A的中的静态代码块");
    }

    {
        System.out.println("子类A的中的非静态代码块 sya()1");
    }

    public static void main(String[] args) {
        ClassLoadOrder a = new ClassLoadOrder();
        System.out.println("A!");
        ClassLoadOrder a2 = new ClassLoadOrder();
        System.out.println("启动完成");
    }

}


class B {

    public B(String cons){
        System.out.println("父类B的含参构造函数");
    }

    static {
        System.out.println("父类B的中的静态代码块");
    }

    public static void callB(){

    }

    {
        System.out.println("父类B的中的非静态代码块 sya()");
    }
}
