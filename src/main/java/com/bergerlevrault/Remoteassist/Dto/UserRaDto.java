package com.bergerlevrault.Remoteassist.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserRaDto {
    private Long userId;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Boolean isAdmin;
    private Set<SessionRaDto> sessions;
}