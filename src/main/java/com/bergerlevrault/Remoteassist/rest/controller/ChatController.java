package com.bergerlevrault.Remoteassist.rest.controller;

import com.bergerlevrault.Remoteassist.Dto.ChatMessage;
import com.bergerlevrault.Remoteassist.Dto.ChatNotifications;
import com.bergerlevrault.Remoteassist.Entity.Chat;
import com.bergerlevrault.Remoteassist.Service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {

    // Injected dependency for handling chat messages
    private final ChatMessageService chatMessageService;

    // Handling messages sent to "/chat.sendMessage"
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        // Simply returns the received message to all subscribers of "/topic/public"
        return chatMessage;
    }

    // Handling messages sent to "/chat.addUser"
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,SimpMessageHeaderAccessor headerAccessor){
        // Add username to the WebSocket session attributes
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        // Return the same message object
        return chatMessage;
    }
}
