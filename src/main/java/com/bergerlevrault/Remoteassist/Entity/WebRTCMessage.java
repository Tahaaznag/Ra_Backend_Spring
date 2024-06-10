package com.bergerlevrault.Remoteassist.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "WebRTCMessage")
@EntityListeners(AuditingEntityListener.class)
public class WebRTCMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String type;
    private String sdp;
    private String candidate;
    private String sdpMid;
    private int sdpMLineIndex;
    @ManyToOne
    @JoinColumn(name = "sessionId")
    private SessionRa roomId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserRa userId;
}