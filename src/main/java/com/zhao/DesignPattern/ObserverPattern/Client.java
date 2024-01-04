package com.zhao.DesignPattern.ObserverPattern;

/**
 *  ==================Java观察者模式【行为设计型】======================
 *  Observer Pattern
 *  它定义了对象之间的一对多依赖关系，当一个对象的状态发生改变时，
 *  所有依赖于它的对象都会得到通知并被自动更新。
 *  =============================================================
 * Description: 客户
 * Author: <a href="">zhaoYi</a>
 * Date: 2024/01/05
 */
public class Client {

    public static void main(String[] args) {
        //①创建发布者和订阅者媒体平台
        ConcreteObserver1 observer1 = new ConcreteObserver1("新华社");
        ConcreteObserver2 observer2 = new ConcreteObserver2("人民日报");
        ConcreteNewsPublisher concreteNewsPublisher = new ConcreteNewsPublisher();

        //②各媒体平台订阅在发布者处注册信息
        concreteNewsPublisher.registerObserver(observer1);
        concreteNewsPublisher.registerObserver(observer2);

        //③临时产生的新闻
        News subject = new ConcreteNews("日本地震", "日本今日凌晨发生一起里氏7.2级地震");

        //④发布者发布临时新闻
        concreteNewsPublisher.publish(subject);
    }
}
