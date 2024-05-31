package com.bergerlevrault.Remoteassist.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;
    private String name;
    @OneToMany(mappedBy = "role")
    private Set<Enrollement> enrollements;
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<UserRa> user;
}
