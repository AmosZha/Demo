package com.zhao.springboot.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.nologging.NoLoggingImpl;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.*;
import java.util.Properties;

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

                    //方法一
                    //ZHAO●TODO: 2023/12/7 言中不允许有内容---问题暂未解决
//                    try {
//                        ClassPathResource classPathResource = new ClassPathResource("application-reggie.properties");
//                        Reader reader = new FileReader(classPathResource.getFile());
//                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

                    //方法二
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfig());
                    //ZHAO●TODO: 2023/12/7 configuration.addMappers("com.zhao.springboot.mapper") 添加mapper映射未生效
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

    private static <T> Configuration mybatisConfig() {
        Configuration configuration = new Configuration();

        configuration.setCacheEnabled(true);
        //configuration.setLazyLoadingEnabled(true);
        //configuration.setAggressiveLazyLoading(true);
        configuration.setMultipleResultSetsEnabled(true);//允许一次查询操作多条语句
        configuration.setUseColumnLabel(true);
        configuration.setCallSettersOnNulls(false);
        configuration.setUseGeneratedKeys(false);//插入自动返回主键
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(false);//驼峰命名自动转换
        configuration.setLogImpl(false ? StdOutImpl.class: NoLoggingImpl.class);
        configuration.setObjectWrapperFactory(new CustomMapWrapperFactory());//自定义工厂，实现返回的Map也可以实现驼峰

        //日志输出 org.apache.ibatis.logging.stdout.StdOutImp.class
        //日志不输出 org.apache.ibatis.logging.nologging.NoLoggingImpl.class

        //PageHelper pager = new PageHelper();
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties p = new Properties();
        p.put("helperDialect", "mysql");
        p.put("offsetAsPageNum", "true");
        p.put("rowBoundsWithCount", "true");
        p.put("pageSizeZero", "true");
        pageInterceptor.setProperties(p);
        configuration.addInterceptor(pageInterceptor);

        configuration.addMappers("com.zhao.springboot.mapper");

        //数据源
        PooledDataSource druidDataSource = new PooledDataSource();
        druidDataSource.setDriver(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        Environment environment=new Environment("development",new JdbcTransactionFactory(),druidDataSource);

        configuration.setEnvironment(environment);
        return configuration;
    }


}
