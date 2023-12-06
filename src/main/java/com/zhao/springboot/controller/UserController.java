package com.zhao.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhao.springboot.entity.User;
import com.zhao.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * （注：系统名称 - 模块名称 - 功能名称）
 * Copyright 1998-2023 company dept
 * @author zhaoYI 2023-11-30 21:32
 * @version 0.1
 * @date 2023-11-30（注：最后更新日期）
 * Modification History:
 *    Date         Author       Version     Description
 * ****************************************************
 *  2023-11-30   zhaoYI       0.1         初始开发
 **/

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("getUserById")
    public User getUserById(String id){
        return userService.getUserById(id);
    }

    @GetMapping("getUserByName")
    public User getUserByName(String name){
        return userService.getUserByName(name);
    }

    @GetMapping("getUserByConditions")
    public User getUserByConditions(@RequestBody String jsonData){
        Map<String, Object> condition = JSONObject.parseObject(jsonData, Map.class);
        return userService.getUserByConditions(condition);
    }


}
