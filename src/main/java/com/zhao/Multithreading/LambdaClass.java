package com.zhao.Multithreading;

/**
 * Lambda表达式演化过程
 **/

public class LambdaClass {

    public static void main(String[] args) {
        Work work = new Programmer();
        work.doWork();

        // 3、局部内部类
        class DatabaseAdministrator implements Work{
            @Override
            public void doWork() {
                System.out.println("上山能打虎，下山能建表");
            }
        }
        work = new DatabaseAdministrator();
        work.doWork();


        // 4、匿名内部类
        work = new Work() {
            @Override
            public void doWork() {
                System.out.println("匿名职位！");
            }
        };
        work.doWork();

        // 5、lambda表达式:替代创建函数式接口中多余代码
        work = () -> System.out.println("lambda表达式-职位");
        work.doWork();

    }

}

// 1、定义函数式接口
interface Work{

    void doWork();

}

// 2、实现类
class Programmer implements Work{

    @Override
    public void doWork() {
        System.out.println("上山能打虎，下山能编程");
    }
}