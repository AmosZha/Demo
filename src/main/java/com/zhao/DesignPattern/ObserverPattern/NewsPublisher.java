package com.zhao.DesignPattern.ObserverPattern;

/**
 * Description: 观察者模式
 * Author: <a href="">zhaoYi</a>
 * Date: 2024/01/04
 */

// 新闻发布者接口
interface NewsPublisher {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void publish(News news);

}