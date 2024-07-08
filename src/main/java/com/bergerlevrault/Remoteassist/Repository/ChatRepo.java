package com.bergerlevrault.Remoteassist.Repository;

import com.bergerlevrault.Remoteassist.Entity.Chat;
import com.bergerlevrault.Remoteassist.Entity.SessionRa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepo extends JpaRepository<Chat,Long> {
    List<Chat> findBySession(SessionRa session);


}
