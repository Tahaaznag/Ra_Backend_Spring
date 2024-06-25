package com.bergerlevrault.Remoteassist.Repository;

import com.bergerlevrault.Remoteassist.Entity.UserRa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRaRepo extends JpaRepository<UserRa, Long> {
    Optional<UserRa> findByEmail(String email);
    boolean existsByUsername(String username);
}
