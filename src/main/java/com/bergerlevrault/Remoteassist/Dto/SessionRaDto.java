package com.bergerlevrault.Remoteassist.Dto;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SessionRaDto {
    private Long sessionId;
    private String sessionName;
    private Date dateDebut;
    private Date dateFin;
    private UserRaDto user;
    private Set<ChatDto> chats;
    private String roomCode; // Ajoutez cette ligne
}