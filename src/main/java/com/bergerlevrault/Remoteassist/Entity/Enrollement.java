package com.bergerlevrault.Remoteassist.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Enrollement") // Pas besoin des guillemets autour de Enrollement
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Enrollement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long enrollementId; // Changer le nom de l'Id pour être cohérent

    @ManyToOne
    @JoinColumn(name = "user_id") // Changer le nom de la colonne pour correspondre à UserRa
    private UserRa user;

    @ManyToOne
    @JoinColumn(name = "session_id") // Changer le nom de la colonne pour correspondre à SessionRa
    private SessionRa session;

    @ManyToOne
    @JoinColumn(name = "role_id") // Changer le nom de la colonne pour correspondre à Role
    private Role role;
}

