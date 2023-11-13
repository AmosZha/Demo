/**
 * 管程法 - 监测消费生产模式
 **/

public class CachePoolPCTest {

    public static void main(String[] args) {

        SynContainer synContainer = new SynContainer();

        System.out.println("容器大小                生产者                       消费者");

        new Productor(synContainer).start();

        new Comsumer(synContainer).start();

    }

}

/**
 * 生产者
 */
class Productor extends Thread{

    SynContainer container;

    Productor(SynContainer container){
        this.container = container;
    }

    /**
     * 生产方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.putChicken(new Chicken(i));
            System.out.println("【" + container.count + "】" +Thread.currentThread().getName() + "生产了一只Chicken 编号："  + i );
        }
    }
}

/**
 * 消费者
 */
class Comsumer extends Thread{

    SynContainer container;

    Comsumer(SynContainer container){
        this.container = container;
    }

    /**
     * 消费方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int id = container.clearChicken().id;
            System.out.println("【" + container.count + "】" + "                                       " + Thread.currentThread().getName() + "消费了一只Chicken 编号" + id );
        }
    }
}

/**
 * 产品
 */
class Chicken{

    //产品编号
    int id;

    Chicken(int id){
        this.id = id;
    }
}

//缓冲区
class SynContainer{

    //容器大小
    // CopyOnWriteArrayList<Chicken> chickenList = new CopyOnWriteArrayList<Chicken>();
    Chicken[] chickenArr = new Chicken[10];

    //容器计数器
    int count = 0;

    // private final ReentrantLock lock = new ReentrantLock();

    //生产产品
    public synchronized void putChicken(Chicken chicken){

        //如果容器满了  需要等待消费者消费
        if(chickenArr.length == count) {
            //通知消费者消费，生产者等待
            try {
                this.wait();
                System.out.println("生产-wait(): 容器满了 等待消费者消费");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果产品容器没有满，则装入产品
        chickenArr[count] = chicken;
        count++;

        //可以通知消费者消费了
        this.notifyAll();

    }


    //消费产品
    public synchronized Chicken clearChicken(){

        Chicken chicken = null;

        //如果容器空了需要等待生产者生产
        if(count == 0) {
            try {
                this.wait();
                System.out.println("消费-wait(): 容器空了需要等待生产者生产");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //没有产品时候：通知生产者生产，消费者等待
        count--;
        chicken = chickenArr[count];

        //产品已经被消费了部分 可以继续生产了
        this.notifyAll();

        return chicken;
    }


}
