package Multithreading;

/**
 * 静态代理
 **/

public class StaticProxy {

    public static void main(String[] args) {

        //WeddingCompany代理类实现猪八戒结婚
        new WeddingCompany(new ZhuBaJie()).happyMarry();

        //Thread类代理了Runnable接口的run()方法
        new Thread( ()-> System.out.println("猪八戒回高老庄娶媳妇咯！") ).start();
    }
}

/**
 * 事件接口：结婚
 */
interface Marry{

    void happyMarry();

}

/**
 * 主角
 * 参与结婚
 */
class ZhuBaJie implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("猪八戒回高老庄娶媳妇咯！");
    }

}

/**
 * 婚庆公司
 * 作用：代理结婚事件
 */
class WeddingCompany implements Marry{

    //代理的东西-结婚
    private Marry marry;

    WeddingCompany(Marry marry){
        this.marry = marry;
    }

    @Override
    public void happyMarry() {
        before();
        this.marry.happyMarry();
        after();
    }

    private void before(){
        System.out.println("结婚前，布置婚礼");
    }

    private void after(){
        System.out.println("结婚后，收尾款");
    }
}
