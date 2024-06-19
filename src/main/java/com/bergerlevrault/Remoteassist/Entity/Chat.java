package com.bergerlevrault.Remoteassist.Entity;
import  jakarta.persistence.*;
import lombok.*;

import java.lang.annotation.Documented;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "\"Chat\"")
@Getter
@Setter
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "chatId")
    private String chatId;

    @ManyToOne
    @JoinColumn(name = "sessionId")
    private SessionRa session;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserRa user;

    private Timestamp chatDate;

    private String senderId;
    private String recipientId;
    private String message;
    private String content;
}
