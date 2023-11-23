package com.zhao.concurrent;

/**
 * 模拟并发卖票操作
 */
public class ConcurrentSimulation {

    public static void main(String[] args){

         // 并发:多线程作同一个资源类，把资源类丢入线程
         Ticket ticket = new Ticket();

         //线程就是一个单独的资源类，没有任何附属的操作
         new Thread(() ->{
             for (int i = 0; i < 20; i++) {
                 ticket.saleTicket();
             }
         }, "线程1").start();

         new Thread(() ->{
             for (int i = 0; i < 20; i++) {
                 ticket.saleTicket();
             }
         },  "线程2").start();

         new Thread(() ->{
             for (int i = 0; i < 20; i++) {
                 ticket.saleTicket();
             }
         },  "线程3").start();


    }
}


/**
 * @description 车票
 * @version 1.0.0
 * @author zhaoYi
 * @date 2023/11/21
 */
class Ticket{

    private int num = 50;

    /**
     * @description 售票
     * @date 2023/11/21
     */
    public synchronized void saleTicket(){
        if (num > 0){
            System.out.println(Thread.currentThread().getName() + "卖出了第" + num-- + "张票； 余票：" + num );
        }
    }

}

/**
 * @description 获取CPU内核数
 * @version 1.0.0
 * @author zhaoYi
 * @date 2023/11/21
 */
class GetCpuCoresNum {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}


