package com.bergerlevrault.Remoteassist.Mapper;

import com.bergerlevrault.Remoteassist.Dto.SessionRaDto;
import com.bergerlevrault.Remoteassist.Entity.SessionRa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;


@Mapper(componentModel = "spring")
public interface SessionMapper {
    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    default SessionRa mapToSession(SessionRaDto sessionDto) {
        if (sessionDto == null) {
            return null;
        }
        SessionRa.SessionRaBuilder sessionBuilder = SessionRa.builder()
                .sessionId(sessionDto.getSessionId())
                .sessionName(sessionDto.getSessionName())
                .dateDebut(sessionDto.getDateDebut())
                .dateFin(sessionDto.getDateFin());
        return sessionBuilder.build();
    }

    default SessionRaDto mapToDto(SessionRa savedSession) {
        if (savedSession == null) {
            return null;
        }
        return SessionRaDto.builder()
                .sessionId(savedSession.getSessionId())
                .sessionName(savedSession.getSessionName())
                .dateDebut(savedSession.getDateDebut())
                .dateFin(savedSession.getDateFin())
                .build();
    }

    List<SessionRaDto> mapToDtoList(List<SessionRa> sessions);
}


