package com.bergerlevrault.Remoteassist.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Getter
@Setter
public class Role {;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Role_Id;
    private String Role_name;

    @OneToMany(mappedBy = "role")
    private Set<Enrollement> enrollements;

}
