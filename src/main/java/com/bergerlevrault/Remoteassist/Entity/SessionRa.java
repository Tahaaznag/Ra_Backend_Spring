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
    private long Session_Id;
    private String Session_Name;
    private Date Date_debut;
    private Date Date_fin;
    private  int User_Id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "session")
    private Set<Chat> chats;

}
