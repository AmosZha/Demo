package com.zhao.DesignPattern.DecoratorPattern;

/**
 * ==================Java装饰器模式【结构型】======================
 * Decorator Pattern
 * 它允许向一个现有的对象添加新的功能，同时又不改变其结构。
 * =============================================================
 * Description: 饮料【抽象组件 Component】
 * 可以是一个接口或者抽象类，其充当被装饰类的原始对象，规定了被装饰s对象的行为
 * Author: <a href="">zhaoYi</a>
 * Date: 2023/12/22
 */
public interface Beverage {

    String getDescription();

    double cost();
}
