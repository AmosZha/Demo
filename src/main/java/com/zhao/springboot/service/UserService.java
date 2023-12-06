package com.zhao.springboot.service;

import com.zhao.springboot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * （注：系统名称 - 模块名称 - 功能名称）
 * Copyright 1998-2023 company dept
 * @author zhaoYI 2023-12-04 14:15
 * @version 0.1
 * @date 2023-12-04（注：最后更新日期）
 * Modification History:
 *    Date         Author       Version     Description
 * ****************************************************
 *  2023-12-04   zhaoYI       0.1         初始开发
 **/

@Service
public interface UserService {

    /**
     * @description 按ID获取用户
     * @param id ID
     * @return @return {@link User }
     * @date 2023/12/04
     */
    public User getUserById(@Param("id")String id);

    /**
     * @description 按名称获取用户
     * @param name 名字
     * @return @return {@link User }
     * @date 2023/12/06
     */
    User getUserByName(@Param("name")String name);

    /**
     * @description 按条件获取用户
     * @param condition 条件
     * @return @return {@link User }
     * @date 2023/12/06
     */
    User getUserByConditions(Map<String, Object> condition);
}
