package com.bergerlevrault.Remoteassist.rest.controller;

import com.bergerlevrault.Remoteassist.Dto.UserRaDto;
import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.Mapper.UserMapper;
import com.bergerlevrault.Remoteassist.Service.Imp.UserRaServiceImp;
import com.bergerlevrault.Remoteassist.utils.ResourcesPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ResourcesPath.CLIENT)
public class UserController {

    private final UserRaServiceImp userRaService;

    public UserController(UserRaServiceImp userRaService) {
        this.userRaService = userRaService;
    }

    @PostMapping(ResourcesPath.USERS)
    public ResponseEntity<UserRaDto> createUser(@RequestBody UserRaDto userDto) {
        UserRaDto ajouteruser = userRaService.createUser(userDto);
        return new ResponseEntity<>(ajouteruser, HttpStatus.OK);
    }

    @GetMapping(ResourcesPath.ALLUSERS)
    public ResponseEntity<List<UserRaDto>> getAllUsers() {
        List<UserRaDto> users = userRaService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(ResourcesPath.USERS + "/{" + ResourcesPath.USERSID + "}")
    public ResponseEntity<UserRaDto> getUserById(@PathVariable Long id) {
        Optional<UserRaDto> user = userRaService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UserRaDto> updateUser(@PathVariable Long id, @RequestBody UserRaDto userDto) {
        try {
            UserRaDto updatedUser = userRaService.updateUser(id, userDto);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRaService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/me")
    @PreAuthorize("hasAuthority('EXPERT') or hasAuthority('ADMIN')")
    public ResponseEntity<UserRaDto> getCurrentUser(@AuthenticationPrincipal UserRa userRa) {
        UserRaDto userDto = userRaService.getCurrentUserDto(userRa);
        return ResponseEntity.ok(userDto);
    }
    @PutMapping("/updateme")
    @PreAuthorize("hasAuthority('EXPERT') or hasAuthority('ADMIN')")
    public ResponseEntity<UserRaDto> updateCurrentUser(@AuthenticationPrincipal UserRa userRa, @RequestBody UserRaDto updatedUserDto) {
        UserRaDto updatedUser = userRaService.updateCurrentUser(userRa.getUserId(), updatedUserDto);
        return ResponseEntity.ok(updatedUser);
    }



}