package com.bergerlevrault.Remoteassist.Repo;

import com.bergerlevrault.Remoteassist.Entity.Atendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendeeRepo extends JpaRepository<Atendee,Long> {
}
