package com.bergerlevrault.Remoteassist.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Blob;
import java.sql.Clob;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "\"Type\"")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)

public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @Lob
    private byte[] File;


}
