package com.zhao.DesignPattern.ObserverPattern;

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
