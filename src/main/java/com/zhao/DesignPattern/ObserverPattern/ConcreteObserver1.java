package com.zhao.DesignPattern.ObserverPattern;

// 具体观察者类1 - 新闻订阅者1
class ConcreteObserver1 implements Observer  {
    private String name;

    public ConcreteObserver1(String name) {
        this.name = name;
    }

    @Override
    public void update(News news) {
        System.out.println(name + " 接收到新闻：" + news.getTitle() + "，内容为：" + news.getContent());
    }
}