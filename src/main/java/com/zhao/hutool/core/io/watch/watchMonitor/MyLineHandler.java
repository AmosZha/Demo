package com.zhao.hutool.core.io.watch.watchMonitor;

import cn.hutool.core.io.LineHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * （注：系统名称 - 模块名称 - 功能名称）
 * Copyright 1998-2023 company dept
 * @author zhaoYI 2023-11-30 21:15
 * @version 0.1
 * @date 2023-11-30（注：最后更新日期）
 * Modification History:
 *    Date         Author       Version     Description
 * ****************************************************
 *  2023-11-30   zhaoYI       0.1         初始开发
 **/

@Slf4j
public class MyLineHandler implements LineHandler {
    @Override
    public void handle(String s) {
        log.info("MyLineHandler  string:" + s);
    }
}
