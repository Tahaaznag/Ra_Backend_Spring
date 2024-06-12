package com.bergerlevrault.Remoteassist.Repository;

import com.bergerlevrault.Remoteassist.Dto.ChatDto;
import com.bergerlevrault.Remoteassist.Entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<Chat,String> {
    List<Chat> findByChatId(String chatId);
}
