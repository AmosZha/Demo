package com.zhao.Multithreading;

/**
 * 多线程实现龟兔赛跑
 **/

public class Race implements Runnable{

    private static String winner = null;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(!isGameOver(i)) {
                //模拟兔子睡觉（20ms）
                if(Thread.currentThread().getName().equals("兔子") && i%50 == 0){
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "--> 跑了" + i + "米");
            }
        }
    }

    /**
     * @Description: 判断比赛是否结束
     * @return: boolean
     * @Date: 2023/11/9
     */
    private boolean isGameOver(int steps){
        if(winner != null) {
            return true;
        }else{
            if(steps == 100) {

                winner = Thread.currentThread().getName();

                System.out.println(Thread.currentThread().getName() + " --》是胜利者！");
                return true;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        new Thread( new Race(), "乌龟").start();
        new Thread( new Race(), "兔子").start();
    }

}


