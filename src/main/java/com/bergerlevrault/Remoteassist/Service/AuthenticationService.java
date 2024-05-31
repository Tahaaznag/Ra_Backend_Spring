package com.bergerlevrault.Remoteassist.Service;

import com.bergerlevrault.Remoteassist.Dto.auth.AuthenticationRegister;
import com.bergerlevrault.Remoteassist.Dto.auth.RegisterRequest;
import com.bergerlevrault.Remoteassist.Dto.auth.TokenResponse;
import org.springframework.messaging.MessagingException;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {
    void register(RegisterRequest request) throws MessagingException;
    TokenResponse authenticate(AuthenticationRegister request);
    void activateAccount(String token) throws MessagingException;

}
