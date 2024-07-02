package com.bergerlevrault.Remoteassist.Repository;

import com.bergerlevrault.Remoteassist.Entity.SessionRa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SessionRaRepo extends JpaRepository<SessionRa,Long> {
    Optional<SessionRa> findByRoomCode(String roomCode);
}