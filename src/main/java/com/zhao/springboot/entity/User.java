package com.zhao.springboot.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * （注：系统名称 - 模块名称 - 功能名称）
 * Copyright 1998-2023 company dept
 * @author zhaoYI 2023-12-04 14:16
 * @version 0.1
 * @date 2023-12-04（注：最后更新日期）
 * Modification History:
 *    Date         Author       Version     Description
 * ****************************************************
 *  2023-12-04   zhaoYI       0.1         初始开发
 **/
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;


    //姓名
    private String name;


    //手机号
    private String phone;


    //性别 0 女 1 男
    private String sex;


    //身份证号
    private String idNumber;


    //头像
    private String avatar;


    //状态 0:禁用，1:正常
    private Integer status;
}
