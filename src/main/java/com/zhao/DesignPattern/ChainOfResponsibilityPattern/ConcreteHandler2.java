package com.zhao.DesignPattern.ChainOfResponsibilityPattern;

class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.startsWith("B")) {
            System.out.println("ConcreteHandler2 处理请求 B");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}