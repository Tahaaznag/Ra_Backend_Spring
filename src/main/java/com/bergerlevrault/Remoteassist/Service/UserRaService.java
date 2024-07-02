package com.bergerlevrault.Remoteassist.Service;

import com.bergerlevrault.Remoteassist.Dto.UserRaDto;
import com.bergerlevrault.Remoteassist.Entity.UserRa;

import java.util.List;
import java.util.Optional;

public interface UserRaService {
    UserRaDto createUser(UserRaDto userDto);
    List<UserRaDto> getAllUsers();
    Optional<UserRaDto> getUserById(Long id);
    UserRaDto updateUser(Long id, UserRaDto userDto);
    void deleteUser(Long id);
    UserRaDto getCurrentUserDto(UserRa userRa);
    UserRaDto updateCurrentUser(Long userId, UserRaDto updatedUserDto);

}