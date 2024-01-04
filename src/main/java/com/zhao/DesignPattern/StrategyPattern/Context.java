package com.zhao.DesignPattern.StrategyPattern;

// 上下文类
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy() {
        strategy.execute();
    }
}