package com.zhao.DesignPattern.ObserverPattern;

// 具体观察者类2 - 新闻订阅者2
class ConcreteObserver2 implements Observer {
    private String name;

    public ConcreteObserver2(String name) {
        this.name = name;
    }

    @Override
    public void update(News news) {
        System.out.println(name + " 接收到新闻：" + news.getTitle() + "，内容为：" + news.getContent());
    }
}  