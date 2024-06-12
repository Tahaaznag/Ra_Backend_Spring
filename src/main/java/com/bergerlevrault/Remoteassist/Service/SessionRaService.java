package com.bergerlevrault.Remoteassist.Service;

import com.bergerlevrault.Remoteassist.Dto.SessionRaDto;
import com.bergerlevrault.Remoteassist.Entity.SessionRa;

import java.util.List;
import java.util.Optional;

public interface SessionRaService {
    SessionRaDto createSession(SessionRaDto sessionDto);

    List<SessionRaDto> getAllSessions();

    List<SessionRaDto> getActiveSessions();

    Object createChat(String senderID, String recipientId);

    Optional<String> getSessionId(String senderID, String recipientId,boolean createNewSessionIfNotExists);
}
