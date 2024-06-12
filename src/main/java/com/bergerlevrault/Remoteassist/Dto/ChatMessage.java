package com.bergerlevrault.Remoteassist.Dto;

import com.bergerlevrault.Remoteassist.Enums.MessageType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    private Integer SessionID;
    private Integer UserID;
    private LocalDateTime DateMessage;
    private String TextMessage;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private MessageType TypeMessage = MessageType.CHAT;
}
