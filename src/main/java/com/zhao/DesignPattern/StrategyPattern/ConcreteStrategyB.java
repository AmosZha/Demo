package com.zhao.DesignPattern.StrategyPattern;

// 具体策略类1
class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("执行策略B的逻辑");
    }
}  