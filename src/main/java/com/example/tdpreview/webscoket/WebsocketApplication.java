package com.example.tdpreview.webscoket;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Slf4j
@Component
public class WebsocketApplication {

    @Resource
    private WebsocketInitialization websocketInitialization;

    @PostConstruct
    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    log.info(Thread.currentThread().getName() + ":websocket启动中......");
                    websocketInitialization.init();
                    log.info(Thread.currentThread().getName() + ":websocket启动成功！！！");
                } catch (Exception e) {
                    log.error("websocket发生错误：", e);
                }
            }
        }).start();

    }
}
