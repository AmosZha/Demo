package com.zhao.DesignPattern.DecoratorPattern;


/**
 * Description: 普通饮料【具体组件 ConcreteComponent】：
 * 实现/继承Component的一个具体对象，也即被装饰对象；
 * Author: <a href="">zhaoYi</a>
 * Date: 2023/12/22
 */
public class SimpleBeverage implements Beverage{

    @Override
    public String getDescription() {
        return "Simple Beverage";
    }

    @Override
    public double cost() {
        return 1.0;
    }
}
