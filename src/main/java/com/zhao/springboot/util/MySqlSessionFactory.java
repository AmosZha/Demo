package com.zhao.springboot.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.Reader;

/**
 * @description SQL会话工厂
 * @version 1.0.0
 * @author zhaoYi
 * @date 2023/12/04
 *
 */
public class MySqlSessionFactory {

    @Value("${demo.mysql.drive}")
    private static String driver;

    @Value("${demo.mysql.url}")
    private static String url;

    @Value("${demo.mysql.username}")
    private static String username;

    @Value("${demo.mysql.password}")
    private static String password;

    private static SqlSessionFactory sqlSessionFactory;

    private static Reader reader;

    static{
        try {
            reader = Resources.getResourceAsReader("application.yml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description 获取SQL会话工厂实例
     * @return @return {@link SqlSessionFactory }
     * @date 2023/12/04
     */
    private static SqlSessionFactory getSqlSessionFactoryInstance(){
        //懒加载模式：如果实例不存在则先创建再返回
        if(sqlSessionFactory == null) {
            //添加同步对象锁 保证线程安全
            //不直接在方法上加synchronized关键字可以避免在每次判断实例是否创建时加锁，极大得提高并发效率
            synchronized (MySqlSessionFactory.class){
                //二次判断:
                // 如果A、B两个线程同时通过第一次判空，A获得锁，B等待，等A创建完SqlSessionFactory实例释放锁，
                // B获得锁，此时B需要再次判断实例是否已创建来避免重复创建
                if(sqlSessionFactory == null) {
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                }
            }
        }

        return sqlSessionFactory;
    }


    /**
     * @description 获取SQL会话
     * @return @return {@link SqlSession }
     * @date 2023/12/04
     */
    public static SqlSession getSqlSession(){
        return getSqlSessionFactoryInstance().openSession();
    }

}
