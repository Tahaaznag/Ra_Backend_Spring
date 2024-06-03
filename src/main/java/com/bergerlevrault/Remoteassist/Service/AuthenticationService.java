package com.bergerlevrault.Remoteassist.Service;

import com.bergerlevrault.Remoteassist.Dto.auth.LoginRequest;
import com.bergerlevrault.Remoteassist.Dto.auth.RegisterRequest;
import com.bergerlevrault.Remoteassist.Dto.auth.LoginResponse;
import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.Exception.UserAlreadyFoundException;
import com.bergerlevrault.Remoteassist.Repository.RoleRepo;
import com.bergerlevrault.Remoteassist.Repository.UserRaRepo;
import lombok.RequiredArgsConstructor;
import com.bergerlevrault.Remoteassist.Enums.Role;
import org.springframework.messaging.MessagingException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final RoleRepo roleRepo;
    private final UserRaRepo userRaRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;



    public LoginResponse register(RegisterRequest registerRequest) throws MessagingException {
        Optional<UserRa> oldUser = this.userRaRepo.findByEmail(registerRequest.email());
        if(oldUser.isPresent()) throw new UserAlreadyFoundException("This email is already taken, please try another one");
        var user= UserRa
                .builder()
                .nom(registerRequest.name())
                .prenom(registerRequest.prenom())
                .email(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password()))
                .role(Role.EXPERT)
                .build();
        this.userRaRepo.save(user);
        var jwtToken=this.jwtService.generateToken(user);
        return LoginResponse.builder()
                .token(jwtToken)
                .build();
    }


    public LoginResponse authenticate(LoginRequest request) {
        try {
            var auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            var claims = new HashMap<String,Object>();
            var user = ((UserRa) auth.getPrincipal());
            claims.put("fullName", user.getNom());

            var jwtToken = jwtService.generateToken(claims, user);
            return LoginResponse.builder()
                    .token(jwtToken)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Invalid credentials");
        }
    }





    public void activateAccount(String token) throws MessagingException {

    }
}
