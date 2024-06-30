package com.bergerlevrault.Remoteassist.Dto;
import com.bergerlevrault.Remoteassist.Entity.SessionRa;
import com.bergerlevrault.Remoteassist.Entity.UserRa;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ChatDto {

    private Long Chat_id;
    private SessionRa session;
    private UserRa user;
    private Timestamp Chat_Date;
    private String Message;

}
