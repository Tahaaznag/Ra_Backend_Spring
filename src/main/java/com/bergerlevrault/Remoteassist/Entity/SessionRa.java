package com.bergerlevrault.Remoteassist.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
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
    @JoinColumn(name = "userId")
    private UserRa user;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private Set<Chat> chats = new HashSet<>();

    private String roomCode;

    public boolean isActive() {
        Date now = new Date();
        return dateDebut.before(now) && dateFin.after(now);
    }
}