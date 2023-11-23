package com.zhao.Multithreading; /**
 * （注：系统名称 - 模块名称 - 功能名称）
 * Copyright 1998-2023 company dept
 *
 * @author zhaoYI 2023-11-13 17:05
 * @version 0.1
 * @date 2023-11-13（注：最后更新日期）
 * Modification History:
 * Date         Author       Version     Description
 * ****************************************************
 * 2023-11-13   zhaoYI       0.1         初始开发
 **/
import java.util.concurrent.*;

/**
 * @Description: 练习异步计算结果
 * @return:
 * @Date: 2023/11/13
 */
public class FutureDemo {
    public static void main(String[] args) throws Exception {
        //1.获取线程池对象
        ExecutorService es = Executors.newCachedThreadPool();
        //2.创建Callable类型对象
        Future<Integer> f = es.submit(new MyCall(1, 1));
        //3.判断任务是否已经完成
        //test1(f);

        //测试get()方法
        //boolean b = f.cancel(true);
        //System.out.println("取消任务执行的结果：" + b);

        Integer v = f.get(4, TimeUnit.SECONDS);//由于等待时间过短，任务来不及执行完成，所以会报异常
        System.out.println("任务执行的结果是："  +v);
    }

    //正常执行流程
    private static void test1(Future<Integer> f) throws Exception {
        boolean done = f.isDone();
        System.out.println("第一次判断任务是否完成：" + done);

        boolean cancelled = f.isCancelled();
        System.out.println("第一次判断任务是否取消：" + cancelled);

        Integer v = f.get();//一直等待任务的执行，直到完成
        System.out.println("任务执行的结果是："  + v);

        //再一次判断任务是否完成
        boolean done2 = f.isDone();
        System.out.println("第二次判断任务是否完成：" + done2);

        boolean cancelled2 = f.isCancelled();
        System.out.println("第二次判断任务是否取消：" + cancelled2);
    }
}


class MyCall implements Callable<Integer>{
    private int a;
    private int b;

    //通过构造方法传递两个参数
    public MyCall(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name + "准备开始计算...");
        Thread.sleep(2000);
        System.out.println(name + "计算完成...");
        return a + b;
    }
}

