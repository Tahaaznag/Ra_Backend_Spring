
package com.bergerlevrault.Remoteassist.Repository;

import com.bergerlevrault.Remoteassist.Entity.Chat;
import com.bergerlevrault.Remoteassist.Entity.WebRTCMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebRTCMessageRepo extends JpaRepository<WebRTCMessage,Long> {
}