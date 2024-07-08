package com.bergerlevrault.Remoteassist.rest.controller;

import com.bergerlevrault.Remoteassist.Dto.ChatDto;
import com.bergerlevrault.Remoteassist.Dto.ChatMessage;
import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.Repository.UserRaRepo;
import com.bergerlevrault.Remoteassist.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Timestamp;
@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;
    @Autowired
    private UserRaRepo userRaRepo;
    @MessageMapping("/chat/{roomCode}")
    @SendTo("/topic/{roomCode}")
    public ChatMessage chat(@DestinationVariable String roomCode, @Payload ChatMessage message) {
        try {
            System.out.println("Received message: " + message);

            // Log pour vérifier le roomCode
            System.out.println("Room code: " + roomCode);

            ChatDto chatDto = new ChatDto();
            chatDto.setMessage(message.getMessage());
            chatDto.setChatDate(new Timestamp(System.currentTimeMillis()));

            // Log avant la recherche de l'utilisateur
            System.out.println("Searching for user: " + message.getUser());

            // Récupérez l'utilisateur à partir du nom d'utilisateur
            UserRa user = userRaRepo.findByNom(message.getUser())
                    .orElseThrow(() -> new RuntimeException("User not found: " + message.getUser()));

            // Log après avoir trouvé l'utilisateur
            System.out.println("Found user: " + user.getUserId());

            ChatDto savedChat = chatService.saveChatMessage(chatDto, roomCode, user.getUserId());

            System.out.println("Saved chat message: " + savedChat);

            return new ChatMessage(savedChat.getMessage(), savedChat.getUser().getNom());
        } catch (Exception e) {
            System.err.println("Error processing chat message: " + e.getMessage());
            e.printStackTrace();
            return new ChatMessage("Error processing message", "System");
        }
    }
}
