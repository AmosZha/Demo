package com.zhao.hutool.core.io.watch.watchMonitor;


import cn.hutool.core.io.file.Tailer;
import cn.hutool.core.io.watch.WatchKind;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.Watcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.WatchEvent;


/**
 * @description 文件监视器
 * @version 1.0.0
 * @author zhaoYi
 * @date 2023/11/30
 * @see ApplicationRunner
 */
@Component
@Slf4j
public class FileMonitor implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        File file = new File("C:\\Users\\86139\\Desktop\\changeFile.txt");
        String fileName = file.getName();
        log.info(fileName + "文件监听已经开始！");

        WatchMonitor watchMonitor = WatchMonitor.create(file, WatchMonitor.EVENTS_ALL);

        WatchMonitor monitor = watchMonitor.setWatcher(new Watcher() {
            @Override
            public void onCreate(WatchEvent<?> watchEvent, Path path) {

                Object context = watchEvent.context();
                log.info("创建：{} --> {}", path, context);
            }

            @Override
            public void onModify(WatchEvent<?> watchEvent, Path path) {
                Object context = watchEvent.context();

                log.info("修改：{} --> {}", path, context);
            }

            @Override
            public void onDelete(WatchEvent<?> watchEvent, Path path) {
                Object context = watchEvent.context();

                log.info("删除：{} --> {}", path, context);

            }

            @Override
            public void onOverflow(WatchEvent<?> watchEvent, Path path) {
                Object context = watchEvent.context();

                log.info("覆盖：{} --> {}", path, context);

            }
        });

        watchMonitor.start();

        Tailer tailer = new Tailer(file, new MyLineHandler());
        tailer.start();

    }
}
