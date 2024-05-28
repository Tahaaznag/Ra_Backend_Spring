package com.bergerlevrault.Remoteassist.Service.Imp;

import com.bergerlevrault.Remoteassist.Dto.UserRaDto;
import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.Mapper.UserMapper;
import com.bergerlevrault.Remoteassist.Repository.UserRaRepo;
import com.bergerlevrault.Remoteassist.Service.UserRaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRaServiceImp implements UserRaService {

    private final UserRaRepo userRaRepo;
    private final UserMapper userMapper;

    public UserRaServiceImp(UserRaRepo userRaRepo, UserMapper userMapper) {
        this.userRaRepo = userRaRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserRaDto createUser(UserRaDto userDto) {
        UserRa user = userMapper.mapToUser(userDto);
        UserRa savedUser = userRaRepo.save(user);
        return userMapper.mapToDto(savedUser);
    }

    @Override
    public List<UserRaDto> getAllUsers() {
        List<UserRa> users = userRaRepo.findAll();
        return userMapper.mapToDtoList(users);
    }

    @Override
    public Optional<UserRaDto> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public UserRaDto updateUser(Long id, UserRaDto userDto) {
        return userRaRepo.findById(id).map(user -> {
            user.setEmail(userDto.getEmail());
            user.setNom(userDto.getNom());
            user.setPrenom(userDto.getPrenom());
            user.setIsAdmin(userDto.getIsAdmin());
            user.setSessions(userDto.getSessions());
            return userRaRepo.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public void deleteUser(Long id) {
        userRaRepo.deleteById(id);
    }
}
