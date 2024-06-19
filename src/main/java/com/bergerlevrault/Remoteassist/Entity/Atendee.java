package com.bergerlevrault.Remoteassist.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "\"Atendee\"")
@Getter
@Setter
public class Atendee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User_Id", referencedColumnName = "userId")
    private UserRa user;

    @ManyToOne
    @JoinColumn(name = "Session_Id", referencedColumnName = "sessionId")
    private SessionRa session;
    private Timestamp date_Debut;
    private Timestamp date_fin;
}
