package com.bergerlevrault.Remoteassist.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "\"UserRa\"")
@EntityListeners(AuditingEntityListener.class)
public class UserRa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Boolean isAdmin;
    @OneToMany(mappedBy = "user")
    private Set<SessionRa> sessions;
}
