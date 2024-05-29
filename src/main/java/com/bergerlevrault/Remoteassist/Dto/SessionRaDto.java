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


    private Long sessionId;

    private String sessionName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;

    private UserRaDto user;

    private Set<ChatDto> chats;

    private Set<EnrollementDto> enrollements;

    private Set<EnrollementDto> attendee;


}
