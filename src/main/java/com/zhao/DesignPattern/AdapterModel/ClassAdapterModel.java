package com.zhao.DesignPattern.AdapterModel;

/**
 * Description: ①类适配器模型
 * 通过继承Adaptee的方式实现在目标接口Target中的对Adaptee类specificRequest()方法的调用
 * Author: <a href="">zhaoYi</a>
 * Date: 2023/12/21
 */
public class ClassAdapterModel extends Adaptee implements Target {
    @Override
    public void request() {
        specificRequest(); // 调用被适配者的方法
    }
}
