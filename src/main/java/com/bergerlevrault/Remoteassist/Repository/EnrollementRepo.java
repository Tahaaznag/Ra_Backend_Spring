package com.bergerlevrault.Remoteassist.Repository;

import com.bergerlevrault.Remoteassist.Entity.Enrollement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollementRepo extends JpaRepository<Enrollement,Long> {
}
