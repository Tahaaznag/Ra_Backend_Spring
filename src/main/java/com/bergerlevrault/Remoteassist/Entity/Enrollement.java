package com.bergerlevrault.Remoteassist.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "\"Enrollement\"")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Enrollement {
//    @EmbeddedId
//    @ManyToOne
//    @MapsId("userId")
//    @JoinColumn(name = "user_id")
//    private UserRa user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User_Id", referencedColumnName = "userId")
    private UserRa user;

    @ManyToOne
    @JoinColumn(name = "Session_Id", referencedColumnName = "sessionId")
    private SessionRa session;

    @ManyToOne
    @JoinColumn(name = "Role_Id", referencedColumnName = "Role_Id")
    private Role role;


}


