package com.bergerlevrault.Remoteassist.Dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RoleDto {;

    private Long Role_Id;
    private String Role_name;

    @OneToMany(mappedBy = "role")
    private Set<EnrollementDto> enrollements;

}
