package com.bergerlevrault.Remoteassist.Service.Imp;

import com.bergerlevrault.Remoteassist.Dto.SessionRaDto;
import com.bergerlevrault.Remoteassist.Entity.SessionRa;
import com.bergerlevrault.Remoteassist.Mapper.SessionMapper;
import com.bergerlevrault.Remoteassist.Repository.SessionRaRepo;
import com.bergerlevrault.Remoteassist.Service.SessionRaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionRaServiceImp implements SessionRaService {

    private final SessionRaRepo sessionRaRepo;
    private final SessionMapper sessionMapper;

    public SessionRaServiceImp(SessionRaRepo sessionRaRepo, SessionMapper sessionMapper) {
        this.sessionRaRepo = sessionRaRepo;
        this.sessionMapper = sessionMapper;
    }

    @Override
    public SessionRaDto createSession(SessionRaDto sessionDto, Long userId) {
        String roomCode = generateUniqueRoomCode();
        SessionRa session = sessionMapper.mapToSession(sessionDto);
        session.setRoomCode(roomCode);
        SessionRa savedSession = sessionRaRepo.save(session);
        return sessionMapper.mapToDto(savedSession);
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
                .filter(SessionRa::isActive) // Assuming you have an `isActive` method or field in `SessionRa`
                .collect(Collectors.toList());
        return sessionMapper.mapToDtoList(activeSessions);
    }
    @Override
    public SessionRaDto joinSession(String roomCode) {
        SessionRa session = sessionRaRepo.findByRoomCode(roomCode)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        return sessionMapper.mapToDto(session);
    }
    private String generateUniqueRoomCode() {
        // Implémentez la logique pour générer un code unique
        return "ROOM" + System.currentTimeMillis();
    }

}