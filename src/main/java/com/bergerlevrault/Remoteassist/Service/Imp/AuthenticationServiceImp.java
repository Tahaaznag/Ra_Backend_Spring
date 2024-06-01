package com.bergerlevrault.Remoteassist.Service.Imp;

import com.bergerlevrault.Remoteassist.Dto.auth.LoginRequest;
import com.bergerlevrault.Remoteassist.Dto.auth.RegisterRequest;
import com.bergerlevrault.Remoteassist.Dto.auth.LoginResponse;
import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.Exception.UserAlreadyFoundException;
import com.bergerlevrault.Remoteassist.Repository.RoleRepo;
import com.bergerlevrault.Remoteassist.Repository.UserRaRepo;
import com.bergerlevrault.Remoteassist.Service.AuthenticationService;
import com.bergerlevrault.Remoteassist.Service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.MessagingException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImp implements AuthenticationService {
    private final RoleRepo roleRepo;
    private final UserRaRepo userRaRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    public void register(RegisterRequest request) throws MessagingException {
        var userRole = roleRepo.findByName("USER")
                .orElseThrow(() -> new IllegalStateException("ROLE USER was not initiated"));
        var user = UserRa.builder()
                .nom(request.getFirstname())
                .prenom(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRaRepo.save(user);
        //sendValidationEmail(user);
    }

    @Override
    public LoginResponse authenticate(LoginRequest request) {
        System.out.println("Method authenticate called");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
            throw e;
        }
        Optional<UserRa> user = this.userRaRepo.findByEmail(request.getEmail());
        if (user.isEmpty()) {
            throw new UserAlreadyFoundException("This email is wrong, please try another one");
        }
        final String jwtToken = jwtService.generateToken(user.get());
        return LoginResponse.builder()
                .token(jwtToken)
                .build();
    }




    @Override
    public void activateAccount(String token) throws MessagingException {

    }
}
