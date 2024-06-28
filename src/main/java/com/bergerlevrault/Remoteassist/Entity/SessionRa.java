package com.bergerlevrault.Remoteassist.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionRa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;
    private String sessionName;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne
    private UserRa user;
    @OneToMany(mappedBy = "session")
    private Set<Chat> chats;
    private String roomCode;

    public boolean isActive() {
        Date now = new Date();
        return dateDebut.before(now) && dateFin.after(now);
    }
}

