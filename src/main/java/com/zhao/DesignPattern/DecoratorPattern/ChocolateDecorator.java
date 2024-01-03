package com.zhao.DesignPattern.DecoratorPattern;

/**
 * Description: 巧克力装饰 【具体装饰器 ConcreteDecorator】
 * Decorator的具体实现类，理论上，每个ConcreteDecorator都扩展了Component对象的一种功能；
 * Author: <a href="">zhaoYi</a>
 * Date: 2023/12/22
 */
public class ChocolateDecorator extends BeverageDecorator {

    public ChocolateDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with chocolate";
    }

    @Override
    public double cost() {
        return super.cost() + 0.75;
    }
}
