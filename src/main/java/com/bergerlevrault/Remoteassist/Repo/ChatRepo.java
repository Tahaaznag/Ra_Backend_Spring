package com.bergerlevrault.Remoteassist.Repo;

import com.bergerlevrault.Remoteassist.Entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepo extends JpaRepository<Chat,Long> {
}
