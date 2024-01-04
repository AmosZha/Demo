package com.zhao.DesignPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

// 具体新闻发布者类
public class ConcreteNewsPublisher implements NewsPublisher{
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void publish(News news) {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }


}
