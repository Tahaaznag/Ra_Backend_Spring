package com.bergerlevrault.Remoteassist.Dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SessionRaDto {

    private String sessionId;
    private String sessionName;

    private Date dateDebut;
    private Date dateFin;

    private UserRaDto user;
    private Set<ChatDto> chats;

    private String senderId;
    private String recipientId;

}
