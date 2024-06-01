package com.bergerlevrault.Remoteassist.rest.controller;

import com.bergerlevrault.Remoteassist.Dto.CustomEntityResponse;
import com.bergerlevrault.Remoteassist.Dto.auth.LoginRequest;
import com.bergerlevrault.Remoteassist.Dto.auth.RegisterRequest;
import com.bergerlevrault.Remoteassist.Dto.auth.LoginResponse;
import com.bergerlevrault.Remoteassist.Service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessagingException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest request) throws MessagingException {
        authenticationService.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/authenticate")
    public CustomEntityResponse<LoginResponse> authenticate(@RequestBody LoginRequest request) {
        System.out.println("tyy");
        return new CustomEntityResponse<>(authenticationService.authenticate(request));
    }

    @GetMapping("/activate-account")
    public void confirm(@RequestParam String token) throws MessagingException {
        authenticationService.activateAccount(token);
    }

}
