package com.bergerlevrault.Remoteassist.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Getter
@Setter
public class Role {;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Role_Id;
    private String Role_name;

}
