package com.bergerlevrault.Remoteassist.Dto;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AtendeeDto {

    private Long id;
    private UserRaDto user;
    private SessionRaDto session;
    private Timestamp date_Debut;
    private Timestamp date_fin;
}
