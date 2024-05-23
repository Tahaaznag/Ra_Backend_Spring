package com.bergerlevrault.Remoteassist.service;

import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.Repo.UserRaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRaService {
    private final UserRaRepo userRaRepo;

    public UserRa createUser(UserRa userDto) {
        UserRa userRa = UserRa.builder()
                .userId(userDto.getUserId())
                .email(userDto.getEmail())
                .nom(userDto.getNom())
                .prenom(userDto.getPrenom())
                .isAdmin(userDto.getIsAdmin())
                .sessions(userDto.getSessions())
                .build();
        return userRaRepo.save(userRa);
    }
}
