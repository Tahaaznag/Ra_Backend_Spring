package com.bergerlevrault.Remoteassist.Dto;
import com.bergerlevrault.Remoteassist.Entity.SessionRa;
import com.bergerlevrault.Remoteassist.Entity.UserRa;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatDto {
    private long chatId;
    private String message;
    private Timestamp chatDate;
    private UserRaDto user;
    private SessionRaDto session;
}