package com.zhao.DesignPattern.DecoratorPattern;

public class IceCreamDecorator extends BeverageDecorator{


    public IceCreamDecorator(Beverage beverage) {
        super(beverage);
    }


    @Override
    public String getDescription() {
        return super.getDescription() + ", with iceCream";
    }

    @Override
    public double cost() {
        return super.cost() + 2;
    }


}
