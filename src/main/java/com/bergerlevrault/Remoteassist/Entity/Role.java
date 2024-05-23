package com.bergerlevrault.Remoteassist.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  Role_Id;

    private String Role_name;


}
