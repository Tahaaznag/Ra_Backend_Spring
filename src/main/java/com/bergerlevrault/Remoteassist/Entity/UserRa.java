package com.bergerlevrault.Remoteassist.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "\"UserRa\"")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class UserRa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String nom;
    private String prenom;
    private String email;
    private String password;
   // private Boolean isAdmin;
    private Boolean isAdmin = false;
    @OneToMany(mappedBy = "user")
    private Set<SessionRa> sessions;

    @OneToMany(mappedBy = "user")
    private Set<Enrollement> enrollements;

    @OneToMany(mappedBy = "user")
    private Set<Enrollement> attendee;

}
