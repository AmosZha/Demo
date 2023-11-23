package com.zhao.Multithreading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * （注：系统名称 - 模块名称 - 功能名称）
 * Copyright 1998-2023 company dept
 *
 * @author zhaoYI 2023-11-11 03:25
 * @version 0.1
 * @date 2023-11-11（注：最后更新日期）
 * Modification History:
 * Date         Author       Version     Description
 * ****************************************************
 * 2023-11-11   zhaoYI       0.1         初始开发
 **/

public class ReentrantLockTest {

    public static void main(String[] args) {

        TicketSell ticketSell = new TicketSell();
        //模拟多个线程同时买票
        new Thread(ticketSell).start();
        new Thread(ticketSell).start();
        new Thread(ticketSell).start();
    }

}

class TicketSell implements  Runnable{

    int ticket = 10;

    //定义自己的可重入锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){

            try {
                //加锁
                lock.lock();

                //执行买票操作
                if(ticket>0) {
                    try {
                        // sleep() 容易模拟出多线程不安全情况
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "买到了第" + ticket-- + "票！");
                }else{
                    break;
                }
            }finally {
                //ReentrantLock最后在finally中释放锁资源
                lock.unlock();
            }

        }
    }
}
