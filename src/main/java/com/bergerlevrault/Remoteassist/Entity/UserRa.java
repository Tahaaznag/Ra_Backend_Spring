package com.bergerlevrault.Remoteassist.Entity;

import com.bergerlevrault.Remoteassist.Enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "UserRa")
@EntityListeners(AuditingEntityListener.class)
public class UserRa implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String nom;
    private String prenom;
    private String email;
    private String username;
    private String password;
    private Boolean isAdmin;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}