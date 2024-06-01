package com.bergerlevrault.Remoteassist.config;

import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.Repository.UserRaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Configuration
@RequiredArgsConstructor
public class BeansConfig {

    private final UserRaRepo userRaRepo;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            UserRa user = userRaRepo.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            // Assuming User implements UserDetails
            return (UserDetails) user;
        };
    }

    @Bean
    public AuthenticationProvider authentificationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager autheticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
