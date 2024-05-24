package com.bergerlevrault.Remoteassist.service;

import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.Repo.UserRaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<UserRa> getAllUsers() {
        return userRaRepo.findAll();
    }

    public Optional<UserRa> getUserById(Long id) {
        return userRaRepo.findById(id);
    }

    public UserRa updateUser(Long id, UserRa userDto) {
        return userRaRepo.findById(id).map(user -> {
            user.setEmail(userDto.getEmail());
            user.setNom(userDto.getNom());
            user.setPrenom(userDto.getPrenom());
            user.setIsAdmin(userDto.getIsAdmin());
            user.setSessions(userDto.getSessions());
            return userRaRepo.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public void deleteUser(Long id) {
        userRaRepo.deleteById(id);
    }
}
