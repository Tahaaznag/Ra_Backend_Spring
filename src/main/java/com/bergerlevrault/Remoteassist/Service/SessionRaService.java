package com.bergerlevrault.Remoteassist.Service;

import com.bergerlevrault.Remoteassist.Dto.SessionRaDto;
import com.bergerlevrault.Remoteassist.Entity.SessionRa;

import java.util.List;

public interface SessionRaService {
    SessionRaDto createSession(SessionRaDto sessionDto);

    List<SessionRaDto> getAllSessions();

    List<SessionRaDto> getActiveSessions();
}
