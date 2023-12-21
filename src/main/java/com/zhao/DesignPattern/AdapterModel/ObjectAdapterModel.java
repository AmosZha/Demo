package com.zhao.DesignPattern.AdapterModel;

/**
 * Description: ②对象适配器模型
 * 通过封装对象Adaptee来实现在目标接口Target中的对Adaptee类specificRequest()方法的调用
 * Author: <a href="">zhaoYi</a>
 * Date: 2023/12/21
 */
public class ObjectAdapterModel implements Target {
    private Adaptee adaptee;

    public ObjectAdapterModel(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest(); // 调用被适配者的方法
    }
}