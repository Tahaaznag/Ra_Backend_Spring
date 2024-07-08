package com.bergerlevrault.Remoteassist.Service.Imp;

import com.bergerlevrault.Remoteassist.Dto.ChatDto;
import com.bergerlevrault.Remoteassist.Entity.Chat;
import com.bergerlevrault.Remoteassist.Entity.SessionRa;
import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.Mapper.ChatMapper;
import com.bergerlevrault.Remoteassist.Repository.ChatRepo;
import com.bergerlevrault.Remoteassist.Repository.SessionRaRepo;
import com.bergerlevrault.Remoteassist.Repository.UserRaRepo;
import com.bergerlevrault.Remoteassist.Service.ChatService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepo chatRepository;

    @Autowired
    private SessionRaRepo sessionRaRepo;

    @Autowired
    private ChatMapper chatMapper;
    @Autowired
    private UserRaRepo userRaRepo;

    @Override
    @Transactional
    public ChatDto saveChatMessage(ChatDto chatDto, String roomCode, Long userId) {
        SessionRa session = sessionRaRepo.findByRoomCode(roomCode)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        UserRa user = userRaRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Chat chat = chatMapper.toEntity(chatDto);
        chat.setSession(session);
        chat.setUser(user);
        Chat savedChat = chatRepository.save(chat);
        return chatMapper.toDto(savedChat);
    }

    @Override
    public List<ChatDto> getChatMessages(String roomCode) {
        SessionRa session = sessionRaRepo.findByRoomCode(roomCode)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        List<Chat> chats = chatRepository.findBySession(session);
        return chats.stream().map(chatMapper::toDto).collect(Collectors.toList());
    }
}
