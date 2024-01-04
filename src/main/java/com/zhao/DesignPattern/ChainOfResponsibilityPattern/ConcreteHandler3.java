package com.zhao.DesignPattern.ChainOfResponsibilityPattern;

class ConcreteHandler3 extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.startsWith("C")) {
            System.out.println("ConcreteHandler3 处理请求 C");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}