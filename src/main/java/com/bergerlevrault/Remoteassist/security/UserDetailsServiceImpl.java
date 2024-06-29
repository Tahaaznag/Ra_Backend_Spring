package com.bergerlevrault.Remoteassist.security;

import com.bergerlevrault.Remoteassist.Repository.UserRaRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRaRepo userRaRepo;

    public UserDetailsServiceImpl(UserRaRepo userRaRepo) {
        this.userRaRepo = userRaRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Attempting to load user with email: " + username);
        return userRaRepo.findByEmail(username)
                .orElseThrow(() -> {
                    System.out.println("User not found with email: " + username);
                    return new UsernameNotFoundException("User not found with email: " + username);
                });
    }
}



