package com.bergerlevrault.Remoteassist.Service.Imp;

import com.bergerlevrault.Remoteassist.Dto.UserRaDto;
import com.bergerlevrault.Remoteassist.Dto.auth.AuthenticationRegister;
import com.bergerlevrault.Remoteassist.Dto.auth.RegisterRequest;
import com.bergerlevrault.Remoteassist.Dto.auth.TokenResponse;
import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.Repository.RoleRepo;
import com.bergerlevrault.Remoteassist.Repository.UserRaRepo;
import com.bergerlevrault.Remoteassist.Service.AuthenticationService;
import com.bergerlevrault.Remoteassist.Service.JwtService;
import org.springframework.messaging.MessagingException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AuthenticationServiceImp implements AuthenticationService {
    private final RoleRepo roleRepo;
    private final UserRaRepo userRaRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AuthenticationServiceImp(RoleRepo roleRepo, UserRaRepo userRaRepo, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.roleRepo = roleRepo;
        this.userRaRepo = userRaRepo;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

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
    public TokenResponse authenticate(AuthenticationRegister request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var claims = new HashMap<String, Object>();
        var user = ((UserRa) auth.getPrincipal());
        //claims.put("fullName", user.getName());
        var jwtToken = jwtService.generateToken(claims, (UserRa) auth.getPrincipal());
        return TokenResponse.builder()
                .token(jwtToken)
                .build();
    }
    @Override
    public void activateAccount(String token) throws MessagingException {

    }
}
