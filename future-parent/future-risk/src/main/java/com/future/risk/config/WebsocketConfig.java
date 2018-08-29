package com.future.risk.config;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.future.risk.websocket.MyWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer, SchedulingConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //设置路径和允许跨域访问
        registry.addHandler(myHandler(), "/market/subscribe").setAllowedOrigins("*");
                //.addInterceptors(new HttpSessionHandshakeInterceptor());
    }

    @Bean()
    public MyWebSocketHandler myHandler() {
        return new MyWebSocketHandler();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar arg0) {
        arg0.setTaskScheduler(new ConcurrentTaskScheduler(
                Executors.newSingleThreadScheduledExecutor()));
        
    }

}
