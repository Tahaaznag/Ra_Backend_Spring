package com.bergerlevrault.Remoteassist.Repository;

import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.Enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRaRepo extends JpaRepository<UserRa, Long> {
    Optional<UserRa> findByEmail(String email);

    List<UserRa> findAllByStatus(Status status);
}
