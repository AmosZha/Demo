package com.zhao.springboot.service.impl;

import com.zhao.springboot.entity.User;
import com.zhao.springboot.mapper.UserMapper;
import com.zhao.springboot.service.UserService;
import com.zhao.springboot.util.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * （注：系统名称 - 模块名称 - 功能名称）
 * Copyright 1998-2023 company dept
 * @author zhaoYI 2023-12-04 17:13
 * @version 0.1
 * @date 2023-12-04（注：最后更新日期）
 * Modification History:
 *    Date         Author       Version     Description
 * ****************************************************
 *  2023-12-04   zhaoYI       0.1         初始开发
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @description 按ID获取用户
     * @param id ID
     * @return @return {@link User }
     * @date 2023/12/04
     */
    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    /**
     * @description 按名称获取用户
     * @param name 名字
     * @return @return {@link User }
     * @date 2023/12/06
     */
    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public User getUserByConditions(Map<String, Object> condition) {
        return userMapper.getUserByConditions(condition);
    }


}
