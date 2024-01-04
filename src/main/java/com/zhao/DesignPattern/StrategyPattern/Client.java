package com.zhao.DesignPattern.StrategyPattern;

/**
 *  ==================Javac策略模式【行为设计型】======================
 *  Strategy Pattern
 *  它提供了一种在运行时根据不同的业务规则或条件选择不同的算法的方法。
 *  在策略模式中，算法的客户端与算法本身解耦，客户端可以根据需要选择不同的算法。
 *  =============================================================
 * Description: 客户
 * Author: <a href="">zhaoYi</a>
 * Date: 2024/01/05
 */// 客户端代码
public class Client {
    public static void main(String[] args) {

        Context context = new Context(new ConcreteStrategyA()); // 设置使用策略A的上下文对象
        context.executeStrategy(); // 执行策略A的逻辑

        context.setStrategy(new ConcreteStrategyB()); // 切换到使用策略B的上下文对象
        context.executeStrategy(); // 执行策略B的逻辑
    }
}