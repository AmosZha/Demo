/**
 * 信号灯法
 **/
public class TrafficLightPCTest {

    public static void main(String[] args) {

        Arena arena = new Arena("苦肉计");

        new ZhouYu(arena).start();
        new HuangGai(arena).start();
    }

}

/**
 * 周瑜
 */
class ZhouYu extends Thread{

    Arena arena;

    public ZhouYu(Arena arena) {
        this.arena = arena;
    }

    /**
     * 攻击
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            arena.attach(arena.name);
            System.out.println("周瑜发起进攻！");
        }
    }
}

/**
 * 黄盖
 */
class HuangGai extends Thread{

    Arena arena;

    public HuangGai(Arena arena) {
        this.arena = arena;
    }

    /**
     * 挨打
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            arena.defend(arena.name);
            System.out.println("黄盖被挨打！");
        }
    }
}

/**
 * 擂台
 */
class Arena {

    //技能名称
    String name;

    //是否发起了进攻【默认：未进攻】
    boolean flag = false;

    public Arena(String name) {
        this.name = name;
    }

    /**
     * @Description: 发起进攻
     * @param name String
     * @return: void
     * @Date: 2023/11/12
     */
    public synchronized void attach(String name){

        if(!flag) {
            //已发起进攻 技能【name】
            this.notifyAll();//通知:可以开始防守了!
        }else{
            //没有进攻的话 则发起进攻
            this.flag = true;
        }

        this.name = name;

    }

    /**
     * @Description: 发起防守
     * @param name String
     * @return: void
     * @Date: 2023/11/12
     */
    public synchronized void defend(String name){

        // 没有发起进攻
        if(!flag) {
            try {
                //暂停防守
                this.wait();
                this.flag = !this.flag;
                this.notifyAll();//通知可以继续进攻了

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //已发动进攻
        else{

        }

    }
}
