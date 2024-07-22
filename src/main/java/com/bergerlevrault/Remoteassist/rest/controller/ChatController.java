package com.bergerlevrault.Remoteassist.rest.controller;

import com.bergerlevrault.Remoteassist.Dto.ChatMessageDto;
import com.bergerlevrault.Remoteassist.Entity.ChatMessage;
import com.bergerlevrault.Remoteassist.Repository.ChatMessageRepo;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "http://localhost:4200" ,  allowCredentials = "true")
public class ChatController {

    private final ChatMessageRepo chatMessageRepo;

    public ChatController(ChatMessageRepo chatMessageRepo) {
        this.chatMessageRepo = chatMessageRepo;
    }

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessageDto chat(@DestinationVariable String roomId, ChatMessageDto messageDto){
        ChatMessage message = new ChatMessage();
        message.setMessage(messageDto.getMessage());
        message.setUser(messageDto.getUser());
        chatMessageRepo.save(message);
        return new ChatMessageDto(message.getMessage(), message.getUser());
    }
}