package com.zhao.DesignPattern.ObserverPattern;

/**
 *  ==================Java观察者模式【行为设计型】======================
 *  Observer Pattern
 *  它定义了对象之间的一对多依赖关系，当一个对象的状态发生改变时，
 *  所有依赖于它的对象都会得到通知并被自动更新。
 *  =============================================================
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