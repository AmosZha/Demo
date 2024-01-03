package com.zhao.DesignPattern.DecoratorPattern;

public class Test {

    public static void main(String[] args) {
        //原有实现类
        Beverage simpleBeverage = new SimpleBeverage();
        System.out.println("============原有实现类============");
        System.out.println(simpleBeverage.getDescription() + " costs " + simpleBeverage.cost());

        //实现抽象类的装饰器后
        Beverage milkDecorator = new MilkDecorator(simpleBeverage);
        System.out.println("============装饰器增强后============");
        System.out.println(milkDecorator.getDescription() + " costs " + milkDecorator.cost());

        //在milk后继续增强
        Beverage chocolateDecorator = new ChocolateDecorator(milkDecorator);
        System.out.println("============装饰器持续增强============");
        System.out.println(chocolateDecorator.getDescription() + " costs " + chocolateDecorator.cost());

        Beverage iceCreamDecorator = new IceCreamDecorator(chocolateDecorator);
        System.out.println(iceCreamDecorator.getDescription() + " costs " + iceCreamDecorator.cost());
    }

}
