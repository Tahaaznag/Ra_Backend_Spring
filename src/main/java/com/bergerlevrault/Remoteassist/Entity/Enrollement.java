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
    private Long User_Id;
    private int Session_Id;
    private int Role_Id;



}


