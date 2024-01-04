package com.zhao.DesignPattern.ObserverPattern;

// 具体新闻类
class ConcreteNews implements News {
    private String title;
    private String content;

    public ConcreteNews(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return content;
    }
}