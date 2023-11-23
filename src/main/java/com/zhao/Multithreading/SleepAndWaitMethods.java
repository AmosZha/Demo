package com.zhao.Multithreading;

/**
 * wait与sleep方法
 * ①：wait(0)相当于wait() 如果没有唤醒 则会无限期等待下去
 * ②：Object.wait和Thread.sleep来自不同类
 * ③：wait会释放锁资源
 * ④：wait必须要在同步代码块中使用（why）
 **/

public class SleepAndWaitMethods {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("线程wait(0)：开始执行");
                try {
                    //相当于无限期等待
                    lock.wait(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程wait(0)：执行结束");
            }
        },"wait(0)");
        t1.start();

        Thread t2 = new Thread(() -> {

            synchronized (lock) {
                System.out.println("线程sleep(0)：开始执行");
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程sleep(0)：执行结束");

                //wait(0)相当于wait() 如果没有唤醒 则会无限期等待下去
                //lock.notify();
            }

        }, "sleep(0)");
        t2.start();
    }

}
