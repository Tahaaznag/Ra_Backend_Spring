package com.bergerlevrault.Remoteassist.Service;

import com.bergerlevrault.Remoteassist.Dto.ChatDto;
import com.bergerlevrault.Remoteassist.Dto.ChatMessage;
import com.bergerlevrault.Remoteassist.Entity.Chat;
import com.bergerlevrault.Remoteassist.Repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final SessionRaService sessionRaService; // Corrected variable name

    public Chat save(Chat chatMessage){
        var chatID = sessionRaService.getSessionId(chatMessage.getSenderId(),
                chatMessage.getRecipientId(), true
        ).orElseThrow();
        chatMessage.setChatId(chatID);
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }

    public List<Chat> findChatMessage(
            String senderId, String recipientId
    ){
        var chatID = sessionRaService.getSessionId(
                senderId,
                recipientId,
                false
        );
        return chatID.map(chatMessageRepository::findByChatID).orElse(new ArrayList<>());
    }
}
