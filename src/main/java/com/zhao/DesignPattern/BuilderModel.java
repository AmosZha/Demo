package com.zhao.DesignPattern;

import lombok.Builder;
import lombok.Getter;

/**
 * Description: 建造者模型
 * Author: <a href="">zhaoYi</a>
 * Date: 2023/12/20
 */
public class BuilderModel {

    User user = User.builder()
            .age(20)
            .name("晓明")
            .email("2724200214@qq.com")
            .build();

}

/**
 * 注解实现方式
 */
/*
@Builder
@Getter
class User{
    private String name;
    private int age;
    private String email;
}
*/

/**
 * 注解编译后代码
 */
class User {
    private String name;
    private int age;
    private String email;

    /**
     * 私有化构造方法
     * @param name
     * @param age
     * @param email
     */
    User(final String name, final int age, final String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    /**
     * 默认创建静态对象建造者类来封装建造过程
     */
    public static class UserBuilder {
        private String name;
        private int age;
        private String email;

        UserBuilder() {
        }

        public UserBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public UserBuilder age(final int age) {
            this.age = age;
            return this;
        }

        public UserBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this.name, this.age, this.email);
        }

        public String toString() {
            return "User.UserBuilder(name=" + this.name + ", age=" + this.age + ", email=" + this.email + ")";
        }
    }
}