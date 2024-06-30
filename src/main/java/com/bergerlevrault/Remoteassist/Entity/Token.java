package com.bergerlevrault.Remoteassist.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Token {
    @Id
    @GeneratedValue
    private Long id;
    private String token;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserRa user;
}
