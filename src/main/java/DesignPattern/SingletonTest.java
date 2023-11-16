package DesignPattern;

/**
 * @description： 单例测试
 * @version：1.0.0
 * @author：zhaoYi
 * @date：2023/11/16
 * @see：
 */
public class SingletonTest{
    public static void main(String args[]) {

        //懒汉模式：线程不安全
        new Thread(ThreadNotSafeSingleton::getInsatnce,"线程A").start();
        new Thread(ThreadNotSafeSingleton::getInsatnce,"线程B").start();
        new Thread(ThreadNotSafeSingleton::getInsatnce,"线程C").start();

        //懒汉模式+同步方法：不占内存 但是效率稍低
        new Thread(ThreadSafeSingletonOne::getInsatnce,"线程D").start();
        new Thread(ThreadSafeSingletonOne::getInsatnce,"线程E").start();
        new Thread(ThreadSafeSingletonOne::getInsatnce,"线程F").start();

        //懒汉模式+同步方法：不占内存 效率稍高
        new Thread(ThreadSafeSingletonTwo::getInsatnce,"线程G").start();
        new Thread(ThreadSafeSingletonTwo::getInsatnce,"线程H").start();
        new Thread(ThreadSafeSingletonTwo::getInsatnce,"线程I").start();

    }
}

/**
 * @description：线程不安全单例
 * @version：1.0.0
 * @author：zhaoYi
 * @date：2023/11/16
 * @see：
 */
class ThreadNotSafeSingleton {

    private static ThreadNotSafeSingleton singleton;

    private ThreadNotSafeSingleton(){
        System.out.println(Thread.currentThread().getName() + ": 这是在构造方法中的一句话，用来验证产生了几个对象");
    }

    public static ThreadNotSafeSingleton getInsatnce(){
        if (singleton == null){


            try {
                //模拟问题的产生
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            singleton = new ThreadNotSafeSingleton();
        }
        return singleton;
    }
}

/**
 * @description: 线程安全单例【同步方法锁(重型锁) - synchronized】
 * @version：1.0.0
 * @author：zhaoYi
 * @date：2023/11/16
 * @see：
 */
class ThreadSafeSingletonOne {

    private static ThreadSafeSingletonOne singleton;

    private ThreadSafeSingletonOne(){
        System.out.println(Thread.currentThread().getName() + ": 这是在构造方法中的一句话，用来验证产生了几个对象");
    }

    public synchronized static  ThreadSafeSingletonOne getInsatnce(){

        if (singleton == null){

            try {
                //模拟问题的产生
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            singleton = new ThreadSafeSingletonOne();
        }
        return singleton;
    }
}

/**
 * @description: 线程安全单例【同步代码块 - synchronized】
 * @version：1.0.0
 * @author：zhaoYi
 * @date：2023/11/16
 * @see：
 */
class ThreadSafeSingletonTwo {

    private static ThreadSafeSingletonTwo singleton;

    private ThreadSafeSingletonTwo(){
        System.out.println(Thread.currentThread().getName() + ": 这是在构造方法中的一句话，用来验证产生了几个对象");
    }

    public static ThreadSafeSingletonTwo getInsatnce(){

        //同步代码块
        synchronized(ThreadSafeSingletonTwo.class){

            try {
                //模拟问题的产生
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (singleton == null){
                singleton = new ThreadSafeSingletonTwo();
            }

        }
        return singleton;
    }
}