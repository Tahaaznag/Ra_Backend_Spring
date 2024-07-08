package com.bergerlevrault.Remoteassist.config;

import com.bergerlevrault.Remoteassist.Dto.ChatMessage;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat-socket","/webrtc-signaling")
                .setAllowedOrigins("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
    @MessageExceptionHandler
    public ChatMessage handleException(Exception exception) {
        System.err.println("Global exception handler: " + exception.getMessage());
        exception.printStackTrace();
        return new ChatMessage("An error occurred", "System");
    }
}
