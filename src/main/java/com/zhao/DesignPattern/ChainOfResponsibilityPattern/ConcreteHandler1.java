package com.zhao.DesignPattern.ChainOfResponsibilityPattern;

// 具体处理者
class ConcreteHandler1 extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.startsWith("A")) {
            System.out.println("ConcreteHandler1 处理请求 A");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}