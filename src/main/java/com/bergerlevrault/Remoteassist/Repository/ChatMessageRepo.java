package com.bergerlevrault.Remoteassist.Repository;

import com.bergerlevrault.Remoteassist.Dto.ChatMessageDto;
import com.bergerlevrault.Remoteassist.Entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepo extends JpaRepository<ChatMessage, Long> {
}
