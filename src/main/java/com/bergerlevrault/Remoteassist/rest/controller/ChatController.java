package com.bergerlevrault.Remoteassist.rest.controller;

import com.bergerlevrault.Remoteassist.Dto.ChatNotifications;
import com.bergerlevrault.Remoteassist.Entity.Chat;
import com.bergerlevrault.Remoteassist.Service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatMessageService chatMessageService;
    private final SimpMessagingTemplate simpleMessagingTemplate;

    @MessageMapping("/chatting")
    public void processMessage(@Payload Chat chatMessage) {
        Chat savedMsg = chatMessageService.save(chatMessage);
        simpleMessagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId(), "/queue/messages",
                new ChatNotifications(
                        savedMsg.getId(),
                        savedMsg.getSenderId(),
                        savedMsg.getRecipientId(),
                        savedMsg.getContent()
                )
        );
    }
    @GetMapping("/message/{senderId}/{recipientId}")
    public ResponseEntity<List<Chat>> findChatMessage(
            @PathVariable("senderId") String senderId,
            @PathVariable("recipientId") String recipientId
    ){
        return ResponseEntity
                .ok(chatMessageService.findChatMessage(senderId, recipientId));
    }

}
