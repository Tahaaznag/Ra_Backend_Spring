package com.bergerlevrault.Remoteassist.Repo;

import com.bergerlevrault.Remoteassist.Entity.UserRa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRaRepo extends JpaRepository<UserRa,Long> {
}
