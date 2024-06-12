package com.bergerlevrault.Remoteassist.Repository;

import com.bergerlevrault.Remoteassist.Entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRepo extends JpaRepository<Chat,Long> {
    Optional<Chat> findBySenderIdAndRecipientId(String senderId, String recipientd);
}
