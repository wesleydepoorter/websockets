package com.wesley.streamgame;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	private Logger logger = Logger.getLogger(WebSocketConfig.class);
	
	@Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		logger.debug("Registering websocket handler");
        registry.addHandler(gameWebSocketHandler(), "/play");
    }

    @Bean
    public WebSocketHandler gameWebSocketHandler() {
        return new GameWebSocketHandler();
    }
}
