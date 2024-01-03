package com.zhao.DesignPattern.DecoratorPattern;

/**
 * Description: 牛奶装饰工 【具体装饰器 ConcreteDecorator】
 * Decorator的具体实现类，理论上，每个ConcreteDecorator都扩展了Component对象的一种功能；
 * Author: <a href="">zhaoYi</a>
 * Date: 2023/12/22
 */
public class MilkDecorator extends BeverageDecorator{

    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with milk";
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }
}
