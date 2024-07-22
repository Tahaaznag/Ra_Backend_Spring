package com.bergerlevrault.Remoteassist.Service.Imp;

import com.bergerlevrault.Remoteassist.Dto.ChatDto;
import com.bergerlevrault.Remoteassist.Dto.SessionRaDto;
import com.bergerlevrault.Remoteassist.Entity.SessionRa;
import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.Mapper.ChatMapper;
import com.bergerlevrault.Remoteassist.Mapper.SessionMapper;
import com.bergerlevrault.Remoteassist.Repository.SessionRaRepo;
import com.bergerlevrault.Remoteassist.Repository.UserRaRepo;
import com.bergerlevrault.Remoteassist.Service.SessionRaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SessionRaServiceImp implements SessionRaService {

    private final SessionRaRepo sessionRaRepo;
    private final UserRaRepo userRaRepo;
    private final SessionMapper sessionMapper;
    private final ChatMapper chatMapper;

    public SessionRaServiceImp(SessionRaRepo sessionRaRepo, UserRaRepo userRaRepo, SessionMapper sessionMapper, ChatMapper chatMapper) {
        this.sessionRaRepo = sessionRaRepo;
        this.userRaRepo = userRaRepo;
        this.sessionMapper = sessionMapper;
        this.chatMapper=chatMapper;
    }

    @Override
    public SessionRaDto createSession(SessionRaDto sessionDto) {

        String sessionCode = generateUniqueSessionCode();
        sessionDto.setSessionCode(sessionCode);

        SessionRa session = sessionMapper.mapToSession(sessionDto);
        SessionRa savedSession = sessionRaRepo.save(session);

        return sessionMapper.mapToDto(savedSession);
    }

    private String generateUniqueSessionCode() {
        return "SESSION" + UUID.randomUUID().toString().substring(0, 6);
    }


    @Override
    public List<SessionRaDto> getAllSessions() {
        List<SessionRa> sessions = sessionRaRepo.findAll();
        return sessionMapper.mapToDtoList(sessions);
    }

    @Override
    public List<SessionRaDto> getActiveSessions() {
        List<SessionRa> sessions = sessionRaRepo.findAll();
        List<SessionRa> activeSessions = sessions.stream()
                .filter(SessionRa::isActive)
                .collect(Collectors.toList());
        return sessionMapper.mapToDtoList(activeSessions);
    }

    @Override
    public SessionRaDto joinSession(String roomCode) {
        SessionRa session = sessionRaRepo.findByRoomCode(roomCode)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        return sessionMapper.mapToDto(session);
    }
    public SessionRaDto getSessionById(Long sessionId) {
        SessionRa session = sessionRaRepo.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        return sessionMapper.mapToDto(session);
    }

    public SessionRa getSessionEntityById(Long sessionId) {
        return sessionRaRepo.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }
    public List<ChatDto> getChatsBySession(String roomCode) {
        SessionRa session = sessionRaRepo.findByRoomCode(roomCode)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        return session.getChats().stream().map(chatMapper::toDto).collect(Collectors.toList());
    }

}
