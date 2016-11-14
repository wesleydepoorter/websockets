package com.wesley.streamgame;


import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class GameWebSocketHandler extends TextWebSocketHandler {
	final static Logger logger = Logger.getLogger(GameWebSocketHandler.class);
	private ArrayList<WebSocketSession> sessions;
	
	public GameWebSocketHandler() {
		sessions = new ArrayList<WebSocketSession>();
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		super.handleTransportError(session, exception);
		logger.error("Transport error: " + exception.getMessage());
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("Handle message received: " + message.getPayload());
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		sessions.add(session);
		logger.info("Session connected: " + session.getId());
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
		logger.info("Session disconnected: " + session.getId());
	}
	
	@SendTo("/topic/game/stats")
	public void sendToAll(String message) throws IOException {
		for(WebSocketSession session: sessions)  {
			session.sendMessage(new TextMessage("Hi there matey"));
		}
	}
}
