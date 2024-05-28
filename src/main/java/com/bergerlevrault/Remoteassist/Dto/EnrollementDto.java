package com.bergerlevrault.Remoteassist.Dto;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EnrollementDto {

    private Long id;

    private UserRaDto user;

    private SessionRaDto session;

    private RoleDto role;


}


