package com.bergerlevrault.Remoteassist.Repo;

import com.bergerlevrault.Remoteassist.Entity.SessionRa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRaRepo extends JpaRepository<SessionRa,Long> {
}
