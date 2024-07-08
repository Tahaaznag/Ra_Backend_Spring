package com.bergerlevrault.Remoteassist.Entity;
import jakarta.persistence.*;
import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long chatId;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private SessionRa session;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserRa user;

    private Timestamp chatDate;
    private String message;
}
