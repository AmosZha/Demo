package com.zhao.DesignPattern.ChainOfResponsibilityPattern;

/**
 * <h3>=============Java责任链模式【结构型】==================</h3>
 * 责任链模式是一种设计模式，在面向对象编程中广泛应用。
 * 它构建了一条由多个对象形成的链，每个对象对其下家的引用形成了链。
 * 当一个请求在链上传递时，会沿着这条链前进，直到某个对象决定处理这个请求。
 * 发出请求的客户端并不知道链上的哪个对象最终处理这个请求，
 * 这使得系统可以在不影响客户端的情况下，动态地重新组织和分配责任。
 * =============================================================
 * Description: 客户端代码
 * Author: <a href="">zhaoYi</a>
 * Date: 2024/01/04
 */
public class Client {
    public static void main(String[] args) {

        //创建三种具体的处理类
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();

        //并依次指定责任链执行顺序
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);

//        handler1.handleRequest("A1"); // ConcreteHandler1 处理请求 A1
//        handler1.handleRequest("B1"); // ConcreteHandler2 处理请求 B1
//        handler1.handleRequest("C1"); // ConcreteHandler3 处理请求 C1
        handler1.handleRequest("D1"); // 没有处理器处理请求 D1，将传递给链中的下一个处理器。如果没有处理器，请求将沿着链传递下去。如果到达链的末尾仍未找到合适的处理器，则该请求将不会得到处理。在这种情况下，将抛出一个异常。
    }
}