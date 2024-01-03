package com.zhao.DesignPattern.DecoratorPattern;


/**
 * <h3>Description: 饮料装饰工【抽象装饰器 Decorator】</h3>
 * <p>通用的装饰ConcreteComponent的装饰器，其内部必然有一个属性指向Component抽象组件；
 * 其实现一般是一个抽象类，主要是为了让其子类按照其构造形式传入一个Component抽象组件，
 * 这是强制的通用行为（当然，如果系统中逻辑单一，并不需要实现许多装饰器，
 * 那么我们可以直接省略该类，而直接实现一个具体装饰器（ComcreteDecorator）即可）</p>
 * Author: <a href="">zhaoYi</a>
 * Date: 2023/12/22
 */
public abstract class BeverageDecorator implements Beverage{

    /**
     * Component抽象组件
     */
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public double cost() {
        return beverage.cost();
    }
}
