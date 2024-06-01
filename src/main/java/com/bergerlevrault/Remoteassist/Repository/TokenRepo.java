package com.bergerlevrault.Remoteassist.Repository;

import com.bergerlevrault.Remoteassist.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface TokenRepo extends JpaRepository<Token,Long> {
}
