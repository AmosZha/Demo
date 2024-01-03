package com.zhao.DesignPattern.AdapterModel;

public class Test {

    public static void main(String[] args) {

        //①类适配器
        ClassAdapterModel classAdapterModel = new ClassAdapterModel();
        classAdapterModel.request();

        //②对象适配器
        Target objectAdapterModel = new ObjectAdapterModel(new Adaptee());
        objectAdapterModel.request();


    }
}
