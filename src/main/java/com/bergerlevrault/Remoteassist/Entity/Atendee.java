package com.bergerlevrault.Remoteassist.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "\"Atendee\"")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Atendee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;
    private int Session_id;
    private Date date_Debut;
    private Date date_fin;
}
