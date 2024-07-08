package com.bergerlevrault.Remoteassist.Service;

import com.bergerlevrault.Remoteassist.Dto.ChatDto;

import java.util.List;

public interface ChatService {
    ChatDto saveChatMessage(ChatDto chatDto, String roomCode, Long userId);
    List<ChatDto> getChatMessages(String roomCode);
}
