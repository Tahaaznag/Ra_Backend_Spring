package com.bergerlevrault.Remoteassist.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "\"SessionRa\"")
@Getter
@Setter
public class SessionRa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sessionId;

    private String sessionName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserRa user;

    @OneToMany(mappedBy = "session")
    private Set<Chat> chats;
}
