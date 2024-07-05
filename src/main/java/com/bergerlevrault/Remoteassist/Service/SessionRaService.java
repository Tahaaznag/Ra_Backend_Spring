package com.bergerlevrault.Remoteassist.Service;

import com.bergerlevrault.Remoteassist.Dto.SessionRaDto;
import com.bergerlevrault.Remoteassist.Entity.SessionRa;

import java.util.List;

public interface SessionRaService {
    SessionRaDto createSession(SessionRaDto sessionDto, Long userId);

    List<SessionRaDto> getAllSessions();

    List<SessionRaDto> getActiveSessions();
    SessionRaDto joinSession(String roomCode);
    SessionRaDto getSessionById(Long sessionId);
    SessionRa getSessionEntityById(Long sessionId);

}