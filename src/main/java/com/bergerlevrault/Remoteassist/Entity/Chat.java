package com.bergerlevrault.Remoteassist.Entity;
import jakarta.persistence.*;
import lombok.*;

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
    private long Chat_id;
    @ManyToOne
    @JoinColumn(name = "session_id")
    private SessionRa session;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserRa user;
    private Date Chat_Date;
    private String Message;

}
