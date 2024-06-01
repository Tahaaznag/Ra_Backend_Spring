package com.bergerlevrault.Remoteassist.Service;

import com.bergerlevrault.Remoteassist.Dto.auth.LoginRequest;
import com.bergerlevrault.Remoteassist.Dto.auth.RegisterRequest;
import com.bergerlevrault.Remoteassist.Dto.auth.LoginResponse;
import org.springframework.messaging.MessagingException;

public interface AuthenticationService {
    void register(RegisterRequest request);
    LoginResponse authenticate(LoginRequest request);
    void activateAccount(String token) throws MessagingException;

}
